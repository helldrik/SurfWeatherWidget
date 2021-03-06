package com.jeldrik.surfweatherwidget.domain.executors;

/**
 * Executor implementation can be based on different frameworks or techniques of asynchronous execution, but every
 * implementation will execute the Interactor out of the UI thread.
 * <p/>
 * Use this class to execute an Interactor.
 *
 * @author Madrid Tech Lab on 31/01/2017.
 */

public interface ThreadExecutor {

    /**
     * Executes a {@link Runnable}.
     *
     * @param runnable The class that implements {@link Runnable} interface.
     */
    void execute(final Runnable runnable);
}
