package com.jeldrik.surfweatherwidget.presentation.executor;

import android.os.Handler;
import android.os.Looper;

import com.jeldrik.surfweatherwidget.domain.executors.PostExecutionThread;

import javax.inject.Inject;


/**
 * MainThread (UI Thread) implementation based on a Handler instantiated with the main application Looper.
 *
 * @author Madrid Tech Lab on 01/02/2017.
 */
public class UiThread implements PostExecutionThread {

    private final Handler handler;

    /**
     * Constructor.
     */
    @Inject
    public UiThread() {
        this.handler = new Handler(Looper.getMainLooper());
    }

    /**
     * Causes the Runnable r to be added to the message queue. The runnable will be run on the main thread.
     *
     * @param runnable {@link Runnable} to be executed.
     */
    @Override
    public void post(Runnable runnable) {
        handler.post(runnable);
    }
}
