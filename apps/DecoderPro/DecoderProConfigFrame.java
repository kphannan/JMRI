// DecoderProConfigFrame.java

package jmri.apps;

import jmri.apps.DecoderProConfigFile;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import org.jdom.Element;
import org.jdom.Attribute;

/** 
 * DecoderProConfigFrame provides startup configuration, a GUI for setting 
 * config/preferences, and read/write support.  Its specific to DecoderPro
 * but should eventually be generalized.  Note that routine GUI config,
 * menu building, etc is done in other code.
 *<P>For now, we're implicitly assuming that configuration of these
 * things is _only_ done here, so that we don't have to track anything
 * else.  When asked to write the config, we just write the values
 * stored in local variables.
 *
 * @author			Bob Jacobsen   Copyright (C) 2001
 * @version			$Id: DecoderProConfigFrame.java,v 1.12 2002-02-20 07:33:46 jacobsen Exp $
 */
public class DecoderProConfigFrame extends jmri.apps.AbstractConfigFrame {
		
	public DecoderProConfigFrame(String name) {
		super(name);
	}		
		
	/**
	 * Abstract method to save the data
	 */
	void saveContents() {
		DecoderProConfigFile f = new DecoderProConfigFile();
		f.makeBackupFile(f.defaultConfigFilename());
		f.writeFile(f.defaultConfigFilename(), this);
	}
		
}
