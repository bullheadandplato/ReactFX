package org.reactfx;

public interface Hold extends AutoCloseable {

    static Hold EMPTY_HOLD = () -> {};

    /**
     * Releases this hold. Does not throw.
     */
    @Override
    void close();

    static Hold multi(Hold... holds) {
        return () -> {
            for(Hold h: holds) {
                h.close();
            }
        };
    }
}
