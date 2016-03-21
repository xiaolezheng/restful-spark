package com.lxz.restful.spark;

import spark.Spark;

public class Main {
    public static void main(String[] args) {
        Spark.get("/hello", (req, res) -> {
            return "hello world";
        });

        Spark.before((req, res) -> {
            res.cookie("uid", "x000343", 1000);
            res.header("uuid", "x000111");
        });

        Spark.after((req, res) -> {
            // res.body(res.body() + "!!!!!");
            res.cookie("uid1", "x000343", 1000);
            res.header("uuid1", "x000111");
        });
    }
}