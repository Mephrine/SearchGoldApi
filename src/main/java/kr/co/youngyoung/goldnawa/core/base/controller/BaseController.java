package kr.co.youngyoung.goldnawa.core.base.controller;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {
    Logger logger = LoggerFactory.getLogger(getClass());

    public Logger getLogger() {
        return logger;
    }
}
