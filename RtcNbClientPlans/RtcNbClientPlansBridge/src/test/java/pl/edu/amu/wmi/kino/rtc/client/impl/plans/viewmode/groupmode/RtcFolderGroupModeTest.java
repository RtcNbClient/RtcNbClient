/*
 * Copyright (C) 2009-2011 RtcNbClient Team (http://rtcnbclient.wmi.amu.edu.pl/)
 *
 * This file is part of RtcNbClient.
 *
 * RtcNbClient is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * RtcNbClient is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with RtcNbClient. If not, see <http://www.gnu.org/licenses/>.
 */
package pl.edu.amu.wmi.kino.rtc.client.impl.plans.viewmode.groupmode;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Pawel Dolecinski
 */
public class RtcFolderGroupModeTest {

    private static RtcFolderGroupMode groupMode;

    /**
     *
     */
    public RtcFolderGroupModeTest() {
    }

    /**
     *
     * @throws Exception
     */
    @BeforeClass
    public static void setUpClass() throws Exception {
        groupMode = new RtcFolderGroupMode();
    }

    /**
     *
     * @throws Exception
     */
    @AfterClass
    public static void tearDownClass() throws Exception {
        groupMode = null;
    }

    /**
     *
     */
    @Before
    public void setUp() {
    }

    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     * Test of groupItems method, of class RtcFolderGroupMode.
     */
    @Test
    public void testGroupItems() {
//        RtcPlanItemGroup[] groupItems = groupMode.groupItems(GroupmodeSuite.planItems);
//        assertEquals(2, groupItems.length);
//
//        String groupLabel = groupItems[0].getGroupLabel();
//        int size = groupItems[0].getPlanItems().length;
//        if (groupLabel.equals("Top Items")) {
//            assertEquals(3, size);
//        } else {
//            assertEquals(5, size);
//        }
    }
}
