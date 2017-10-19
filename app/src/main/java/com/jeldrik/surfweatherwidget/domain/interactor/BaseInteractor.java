package com.jeldrik.surfweatherwidget.domain.interactor;

import android.support.annotation.NonNull;

import com.jeldrik.surfweatherwidget.domain.executors.PostExecutionThread;
import com.jeldrik.surfweatherwidget.domain.executors.ThreadExecutor;

/**
 * Base interactor that executes a task in background thread and post the result to a callback that will be executed in
 * the UI thread.
 *
 * @author Madrid Tech Lab on 31/01/2017.
 */
abstract class BaseInteractor implements Runnable {


    private final ThreadExecutor threadExecutor;

    private final PostExecutionThread postExecutionThread;

    /**
     * Constructor.
     *
     * @param threadExecutor      The thread executor.
     * @param postExecutionThread The post execution thread.
     */
    BaseInteractor(@NonNull ThreadExecutor threadExecutor, @NonNull PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    /**
     * Executes the operation in background.
     */
    protected void execute() {
        threadExecutor.execute(this);
    }

    /**
     * Returns the result of the operation on the UI thread.
     *
     * @param runnable The UI runnable.
     */
    void post(@NonNull Runnable runnable) {
        postExecutionThread.post(runnable);
    }

}
