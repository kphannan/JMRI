package jmri.jmrix.oaktree.serialmon;

import java.awt.GraphicsEnvironment;
import jmri.util.JUnitUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import jmri.jmrix.oaktree.SerialTrafficControlScaffold;
import jmri.jmrix.oaktree.OakTreeSystemConnectionMemo;
import jmri.jmrix.oaktree.SerialTrafficController;

/**
 * Test simple functioning of SerialMonAction
 *
 * @author	Paul Bender Copyright (C) 2016
 */
public class SerialMonActionTest {

    private SerialTrafficController tc = null;
    private OakTreeSystemConnectionMemo m = null;
 
    @Test
    public void testStringCtor() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        SerialMonAction action = new SerialMonAction("OakTree test Action",m); 
        Assert.assertNotNull("exists", action);
    }

    @Test
    public void testCtor() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        SerialMonAction action = new SerialMonAction(m); 
        Assert.assertNotNull("exists", action);
    }

    @Before
    public void setUp() {
        JUnitUtil.setUp();
        m = new OakTreeSystemConnectionMemo();
        tc = new SerialTrafficControlScaffold(m);
        m.setSystemPrefix("ABC");
        m.setTrafficController(tc);
    }

    @After
    public void tearDown() {        JUnitUtil.clearShutDownManager(); // put in place because AbstractMRTrafficController implementing subclass was not terminated properly
        JUnitUtil.tearDown();
    }
}
