package org.aksw.defacto.restful.utils;

import java.io.File;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 *
 * @author rspeck
 *
 */
public class CfgManager {

  public static final Logger LOG = LogManager.getLogger(CfgManager.class);

  /**
   * 
   * @param className
   * @return
   */
  public static XMLConfiguration getCfg(final String className) {

    final String file = Cfg.CFG_FOLDER + File.separator + className + ".xml";
    String fileDefault = Cfg.CFG_FOLDER + File.separator + Cfg.CFG_FILE + ".xml";

    if (new File(file).exists()) {
      fileDefault = file;
    }

    LOG.info("load " + fileDefault);
    try {
      return new XMLConfiguration(fileDefault);
    } catch (final ConfigurationException e) {
      LOG.error(e.getLocalizedMessage(), e);
    }
    return null;
  }

  /**
   * 
   * @param className
   * @return
   */
  public static XMLConfiguration getCfg(final Class<?> classs) {
    return CfgManager.getCfg(classs.getName());
  }
}
