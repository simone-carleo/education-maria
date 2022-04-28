package it.adt.mvntestproject.service.impl;

import it.adt.mvntestproject.service.ComparisonService;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class ComparisonServiceImpl implements ComparisonService {

    final static Logger logger = LogManager.getLogger(ComparisonServiceImpl.class);

    @Override public void compareString(String nameCost, String name) {

        if (StringUtils.equals(nameCost, name)) {
            logger.info("Le stringhe nameCost {} e name {} sono uguali", nameCost, name);
        } else {
            logger.warn("Le stringhe nameCost {} e name {} sono differenti", nameCost, name);
        }

    }
}
