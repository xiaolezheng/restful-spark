package com.lxz.restful.spark;

import lombok.extern.slf4j.Slf4j;
import spark.Spark;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Spark.get("/hello", (req, res) -> {
            return "hello world";
        });

        Spark.before((req, res) -> {
            log.debug("req before header {}", req.headers());
            res.cookie("uid", "x000343", 1000);
            res.header("uuid", "x000111");
        });

        Spark.after((req, res) -> {
            log.debug("req after header {}", req.headers());

            // res.body(res.body() + "!!!!!");
            res.cookie("uid1", "x000343", 1000);
            res.header("uuid1", "x000111");
        });
    }
}