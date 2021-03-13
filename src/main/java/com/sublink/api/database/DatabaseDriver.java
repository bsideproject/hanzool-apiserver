package com.sublink.api.database;

public interface DatabaseDriver extends UserDB, ContentDB {
    enum ResultCode {
        SUCCESS("Success"),
        NOT_FOUND("Not_found"),
        INTERNAL_ERROR("Internal Error"),
        INVALID_INPUT("Invalid Input");


        final private String result;

        ResultCode(String result) {
            this.result = result;
        }

        @Override
        public String toString() {
            return result;
        }
    }

    boolean Initialize();
}
