package com.lxz.restful.spark;

import lombok.extern.slf4j.Slf4j;
import spark.Spark;

@Slf4j
public class Main {
    private static final String CHARSET = "UTF-8";

    public static void main(String[] args) {
        Spark.get("/hello", (req, res) -> {
            return "hello world 你好";
        });

        Spark.before((req, res) -> {
            log.debug("req before header {}", req.headers());
            req.raw().setCharacterEncoding(CHARSET);

            res.cookie("uid", "x000343", 1000);
            res.header("uuid", "x000111");
        });

        Spark.after((req, res) -> {
            log.debug("req after header {}", req.headers());
            res.raw().setCharacterEncoding(CHARSET);

            // res.body(res.body() + "!!!!!");
            res.cookie("uid1", "x000343", 1000);
            res.header("uuid1", "x000111");
        });
    }
}