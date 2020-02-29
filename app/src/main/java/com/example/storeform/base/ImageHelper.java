package com.example.storeform.base;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.media.MediaMetadataRetriever;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.example.storeform.R;
import com.example.storeform.control.PreferenceUtil;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class ImageHelper {
    /**
     * quannk
     *
     * @param link
     * @return
     */
    public static String[] replaceLinkThumb(String link, int feedLinkSize, int thumbLinkSize, Context context) {

        String[] listLink = new String[2];
        Logger.d("replaceLinkThumb: "+link);
        if (link.contains("thumb_w") || link.contains("crop")) {
            listLink[0] = link;
            listLink[1] = link;
            return listLink;
        } else if (BaseStorage.getInstance().listDomainThumb != null && BaseStorage.getInstance().listDomainThumb.size() > 0) {
            List<String> tmpThumbs = BaseStorage.getInstance().listDomainThumb;
//            Logger.d("replaceLinkThumb Size: " + tmpThumbs.size());
            for (int i = 0; i < tmpThumbs.size(); i++) {
                String s = BaseStorage.getInstance().listDomainThumb.get(i);
//                Logger.d("replaceLinkThumb: " + s);
//                Logger.d("replaceLinkThumb link: " + link);
                if (link.contains(s)) {
                    listLink[0] = link.replace(s, s + "/thumb_w/" + feedLinkSize);
                    listLink[1] = link.replace(s, s + "/thumb_w/" + thumbLinkSize);
//                    Logger.d("replaceLinkThumb 0: " + listLink[0]);
//                    Logger.d("replaceLinkThumb 1: " + listLink[1]);
                    return listLink;

                }
            }

        } else {
            try {
                BaseStorage.getInstance().listDomainThumb = new ArrayList<>();
                PreferenceUtil preferenceUtil = new PreferenceUtil(context);
                String domainThumb = preferenceUtil.getDomainThumb();
                if (domainThumb != null && domainThumb.length() > 0) {
                    try {
                        JSONArray jsonArray = new JSONArray(domainThumb);
                        if (jsonArray != null && jsonArray.length() > 0) {
                            BaseStorage.getInstance().listDomainThumb = new ArrayList<>();
                            for (int i = 0; i < jsonArray.length(); i++) {
                                if (jsonArray.getString(i) != null) {
                                    BaseStorage.getInstance().listDomainThumb.add(jsonArray.getString(i));
                                }
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return listLink;

    }

    public static void saveBitmap(Context mContext, String link) {
        if (link != null && link.length() > 0) {
            Logger.d("quannk", "preload: " + link);
            Glide.with(mContext).load(link).preload();
        }

    }

    /**
     * thaond load cho feed
     *
     * @param context
     * @param imageView
     * @param link
     * @param Rootlink
     */
    public static void loadFeedImage(Context context, ImageView imageView, String link, String Rootlink) {

        if (link != null && link.length() > 0 && !link.contains("crop")) {
            String tmpLink = "", tmpThumb = "";
            String[] listLink = replaceLinkThumb(link, BaseStorage.getInstance().feedLinkSize, BaseStorage.getInstance().feedThumbSize, context);
            tmpLink = listLink[0];
            tmpThumb = listLink[1];
            if (tmpLink != null && tmpLink.length() > 0 && tmpThumb != null && tmpThumb.length() > 0) {
                Logger.d("thaond", "tmpLink: " + tmpLink);
                Logger.d("thaond", "tmpThumb: " + tmpThumb);

                Glide.with(context)
                        .load(tmpLink).thumbnail(
                        Glide.with(context)
                                .load(tmpThumb).apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL)))
                        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
                        .apply(RequestOptions.errorOf(R.drawable.bg_placeholder))
                        .apply(RequestOptions.placeholderOf(R.drawable.bg_placeholder)).listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        Logger.d("thaond", "tmpThumbError: " + e.getMessage());
                        Logger.d("thaond", "tmpLinkError: " + e.getMessage());
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                })
                        .into(imageView);
                ImageHelper.saveBitmap(context, link);
            } else {
                Logger.d("thaond", "Link: " + link);
                Glide.with(context)
                        .load(link).thumbnail(0.1f)
                        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
                        .apply(RequestOptions.errorOf(R.drawable.bg_placeholder))
                        .apply(RequestOptions.placeholderOf(R.drawable.bg_placeholder))
                        .into(imageView);
            }

        } else if (Rootlink != null && Rootlink.length() > 0) {
            Glide.with(context)
                    .load(Rootlink).thumbnail(0.1f)
                    .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
                    .apply(RequestOptions.errorOf(R.drawable.bg_placeholder))
                    .apply(RequestOptions.placeholderOf(R.drawable.bg_placeholder))
                    .into(imageView);
        } else {
            imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.bg_placeholder));
        }
    }

    public static void loadImage(Context context, ImageView imageView, String link) {
        if (link != null && link.length() > 0) {

           /* Glide.with(context)
                    .load(link).thumbnail(0.1f)
                    .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
                    .apply(RequestOptions.errorOf(R.drawable.bg_placeholder))
                    .apply(RequestOptions.placeholderOf(R.drawable.bg_placeholder))
                    .into(imageView);*/


            String tmpLink = "", tmpThumb = "";
            String[] listLink = replaceLinkThumb(link, BaseStorage.getInstance().feedLinkSize, BaseStorage.getInstance().feedThumbSize, context);
            tmpLink = listLink[0];
            if (tmpLink != null && tmpLink.length() > 0) {
//                Logger.d("thaond", "tmpLink: " + tmpLink);
//                Logger.d("thaond", "tmpThumb: " + tmpThumb);

                Glide.with(context)
                        .load(link).thumbnail(
                        Glide.with(context)
                                .load(tmpLink).apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL)))
                        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
                        .apply(RequestOptions.errorOf(R.drawable.bg_placeholder))
                        .apply(RequestOptions.placeholderOf(R.drawable.bg_placeholder)).listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
//                        Logger.d("thaond", "tmpThumbError: " + e.getMessage());
//                        Logger.d("thaond", "tmpLinkError: " + e.getMessage());
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                })
                        .into(imageView);
            } else {
//                Logger.d("thaond", "Link: " + link);
                Glide.with(context)
                        .load(link).thumbnail(0.1f)
                        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
                        .apply(RequestOptions.errorOf(R.drawable.bg_placeholder))
                        .apply(RequestOptions.placeholderOf(R.drawable.bg_placeholder))
                        .into(imageView);
            }
        } else {
            imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.bg_placeholder));
        }
    }

    /**
     * thaond load image cho feed
     *
     * @param context
     * @param imageView
     * @param link
     */
    public static void loadFeedImage(Context context, ImageView imageView, String link) {
        if (link != null && link.length() > 0) {

         /*   Glide.with(context)
                    .load(link).thumbnail(0.1f)
                    .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
                    .apply(RequestOptions.errorOf(R.drawable.bg_placeholder))
                    .apply(RequestOptions.placeholderOf(R.drawable.bg_placeholder))
                    .into(imageView);*/
            String tmpLink = "", tmpThumb = "";
            String[] listLink = replaceLinkThumb(link, BaseStorage.getInstance().feedLinkSize, BaseStorage.getInstance().feedThumbSize, context);
            tmpLink = listLink[0];
            tmpThumb = listLink[1];
            if (tmpLink != null && tmpLink.length() > 0 && tmpThumb != null && tmpThumb.length() > 0) {
//                Logger.d("thaond", "tmpLink: " + tmpLink);
//                Logger.d("thaond", "tmpThumb: " + tmpThumb);

                Glide.with(context)
                        .load(tmpLink).thumbnail(
                        Glide.with(context)
                                .load(tmpThumb).apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL)))
                        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
                        .apply(RequestOptions.errorOf(R.drawable.bg_placeholder))
                        .apply(RequestOptions.placeholderOf(R.drawable.bg_placeholder)).listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        Logger.d("thaond", "tmpThumbError: " + e.getMessage());
                        Logger.d("thaond", "tmpLinkError: " + e.getMessage());
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                })
                        .into(imageView);
                //load them anh goc neu click vao detail
                ImageHelper.saveBitmap(context, link);

            } else {
                Logger.d("thaond", "Link: " + link);
                Glide.with(context)
                        .load(link).thumbnail(0.1f)
                        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
                        .apply(RequestOptions.errorOf(R.drawable.bg_placeholder))
                        .apply(RequestOptions.placeholderOf(R.drawable.bg_placeholder))
                        .into(imageView);
            }
        }
    }

    /**
     * thaond load image cho frame o feed
     *
     * @param context
     * @param imageView
     * @param link
     */
    public static void loadImageFrame(Context context, ImageView imageView, String link) {
        if (link != null && link.length() > 0) {

         /*   Glide.with(context)
                    .load(link).thumbnail(0.1f)
                    .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
                    .apply(RequestOptions.errorOf(R.drawable.bg_placeholder))
                    .apply(RequestOptions.placeholderOf(R.drawable.bg_placeholder))
                    .into(imageView);*/
            String tmpLink = "", tmpThumb = "";
            String[] listLink = replaceLinkThumb(link, BaseStorage.getInstance().frameLinkSize, BaseStorage.getInstance().frameThumbSize, context);
            tmpLink = listLink[0];
            tmpThumb = listLink[1];
            if (tmpLink != null && tmpLink.length() > 0 && tmpThumb != null && tmpThumb.length() > 0) {
                Logger.d("thaond", "tmpLink: " + tmpLink);
                Logger.d("thaond", "tmpThumb: " + tmpThumb);

                Glide.with(context)
                        .load(tmpLink).thumbnail(
                        Glide.with(context)
                                .load(tmpThumb).apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL)))
                        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
                        .apply(RequestOptions.errorOf(R.drawable.bg_placeholder))
                        .apply(RequestOptions.placeholderOf(R.drawable.bg_placeholder)).listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        Logger.d("thaond", "tmpThumbError: " + e.getMessage());
                        Logger.d("thaond", "tmpLinkError: " + e.getMessage());
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                })
                        .into(imageView);

            } else {
                Logger.d("thaond", "Link: " + link);
                Glide.with(context)
                        .load(link).thumbnail(0.1f)
                        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
                        .apply(RequestOptions.errorOf(R.drawable.bg_placeholder))
                        .apply(RequestOptions.placeholderOf(R.drawable.bg_placeholder))
                        .into(imageView);
            }
        } else {
            imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.bg_placeholder));
        }
    }

    /**
     * Quangdv clone cho phan load blur
     *
     * @param context
     * @param imageView
     * @param link
     */
    public static void loadImageFrameBlur(Context context, ImageView imageView, String link) {
        if (link != null && link.length() > 0) {
            String tmpLink = "", tmpThumb = "";
            String[] listLink = replaceLinkThumb(link, BaseStorage.getInstance().frameLinkSize, BaseStorage.getInstance().frameThumbSize, context);
            tmpLink = listLink[0];
            tmpThumb = listLink[1];
            if (tmpLink != null && tmpLink.length() > 0 && tmpThumb != null && tmpThumb.length() > 0) {
                Logger.d("thaond", "tmpLink: " + tmpLink);
                Logger.d("thaond", "tmpThumb: " + tmpThumb);

                Glide.with(context)
                        .load(tmpLink).thumbnail(
                        Glide.with(context)
                                .load(tmpThumb).apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL)))
                        .transform(new BlurTransformation())
                        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
                        .apply(RequestOptions.errorOf(R.drawable.bg_placeholder))
                        .apply(RequestOptions.placeholderOf(R.drawable.bg_placeholder)).listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        Logger.d("thaond", "tmpThumbError: " + e.getMessage());
                        Logger.d("thaond", "tmpLinkError: " + e.getMessage());
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                })
                        .into(imageView);

            } else {
                Logger.d("thaond", "Link: " + link);
                Glide.with(context)
                        .load(link).thumbnail(0.1f)
                        .transform(new BlurTransformation())
                        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
                        .apply(RequestOptions.errorOf(R.drawable.bg_placeholder))
                        .apply(RequestOptions.placeholderOf(R.drawable.bg_placeholder))
                        .into(imageView);
            }
        } else {
            imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.bg_placeholder));
        }
    }


    public static void loadImageAvatar(Context context, ImageView imageView, String link) {
        if (link != null && link.length() > 0) {
            if (!link.contains("crop")) {
                String tmpLink = "", tmpThumb = "";
                Logger.d("thaond", "extension link: " + link);
                String[] listLink = replaceLinkThumb(link, BaseStorage.getInstance().avatarLinkSize, BaseStorage.getInstance().avatarThumbSize, context);
                tmpLink = listLink[0];
                if (tmpLink != null && tmpLink.length() > 0) {
                    Logger.d("thaond", "tmpLinkAvatar: " + tmpLink);
                    Logger.d("thaond", "tmpThumbAvatar: " + tmpThumb);

                    Glide.with(context)
                            .load(tmpLink).thumbnail(
                            Glide.with(context)
                                    .load(tmpThumb).apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL)))
                            .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
                            .apply(RequestOptions.errorOf(R.drawable.ic_no_avatar))
                            .apply(RequestOptions.placeholderOf(R.drawable.ic_no_avatar)).listener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            Logger.d("thaond", "tmpThumbErrorAvatar: " + e.getMessage());
                            Logger.d("thaond", "tmpLinkErrorAvatar: " + e.getMessage());
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            return false;
                        }
                    })
                            .into(imageView);
                } else {
                    Logger.d("thaond", "LinkAvatar: " + link);
                    Glide.with(context)
                            .load(link).thumbnail(0.1f)
                            .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
                            .apply(RequestOptions.errorOf(R.drawable.ic_no_avatar))
                            .apply(RequestOptions.placeholderOf(R.drawable.ic_no_avatar))
                            .into(imageView);
                }
            } else {
                Logger.d("thaond", "LinkAvatar: " + link);
                Glide.with(context)
                        .load(link).thumbnail(0.1f)
                        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
                        .apply(RequestOptions.errorOf(R.drawable.ic_no_avatar))
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_no_avatar))
                        .into(imageView);
            }


        } else {
            imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_no_avatar));
            Logger.d("thaond", "tmpLinkAvatar no avatar ");

        }

    }




    public static long gcm(long a, long b) {
        return b == 0 ? a : gcm(b, a % b);
    }

    public static String getDimentionRatio(Integer width, Integer height) {
        return (width != null && width > 0 && height != null && height > 0) ? (width / gcm(width, height) + ":" + height / gcm(width, height)) : AppData.DEFAULT_DIMENTION_RATIO;
    }

    public static String convertUrlToHttps(String url) {
        String urlResult = "";

        if (url != null && !url.equals("")) {
            if (url.contains("https")) {
                return url;
            } else {
                urlResult = url.replace("http", "https");
            }
        }
        return urlResult;
    }

}
