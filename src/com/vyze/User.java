package com.vyze;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * Created by Julian on 5/6/2015.
 */
public class User {

    public Future<Miniworld[]> getMiniworlds() {
        /*Future<Miniworld[]> miniworlds = Connection.executor.submit(new Callable<Miniworld[]>() {
            @Override
            public Miniworld[] call() throws Exception {
                return new Miniworld[0];
            }
        });

        return miniworlds;*/
        return null;
    }

}
