package com.example.storeform.base;

/**
 * Created by Quannk
 */
public interface AppData {
    String DEFAULT_DIMENTION_RATIO = "16:9";

    class PoolMechenic {
        public static final int MODE_RANK = 3;
        public static final int MODE_TIME = 1;
        public static final int MODE_BASE_SCORE = 2;

        public static final int FIRST_NORANK = 1;
        public static final int FIRST_RANK = 0;

        public static final int GET_CARD_MIN = 15;
        public static final int GET_CARD_MAX = 45;
    }

    enum BackgroundType {
        POST(1),
        OTHER(2);

        private int id;

        BackgroundType(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }

    /**
     * Thông tin khởi tạo cho player
     * bản chính: com.vcc.kinghub
     * Bản dev: com.vcc.kinghub.dev
     */
    interface Video {
        String APP_KEY = "p352k1g3go5ct7zjirhbd5665yf1706d";
        String SECRET_KEY = "ocCLp689oYPbhYbNaItXOWc3CJtJ6ElhgclycLB5fbZretwZX8RXUJnXZXaqmp51";
        String PLAYER_ID = "100396";
    }
}
