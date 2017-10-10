package com.jeldrik.surfweatherwidget.domain.executors;

/**
 * Thread abstraction created to change the execution context from any thread to any other thread. Useful to encapsulate
 * a UI Thread for example, since some job will be done in background, an implementation of this interface will change
 * context and update the UI.
 *
 * @author Madrid Tech Lab on 31/01/2017.
 */

public interface PostExecutionThread {

    /**
     * Causes the {@link Runnable} to be added to the message queue of the NativeMain UI Thread of the application.
     *
     * @param runnable {@link Runnable} to be executed.
     */
    void post(Runnable runnable);
}
