package com.example;

import net.spy.memcached.MemcachedClient;
import java.io.IOException;
import java.net.InetSocketAddress;

public class MemcachedExample {

    public static void setGetRemoveFromMemcached(String key, String value) {
        try {
            // Connect to Memcached server on localhost and default port 11211
            MemcachedClient client = new MemcachedClient(new InetSocketAddress("localhost", 11211));

            client.set(key, 3600, value);

            // Retrieve and print the data from Memcached server
            Object myObject = client.get(key);
            System.out.println("Retrieved value: " + myObject);

            // Delete the data from Memcached
            client.delete(key);

            // Close the Memcached client
            client.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}