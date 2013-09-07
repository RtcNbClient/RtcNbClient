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
package pl.edu.amu.wmi.kino.rtc.client.ui.api.workitems.view;

import org.openide.nodes.Node;
import pl.edu.amu.wmi.kino.netbeans.mvp.client.Display;
import pl.edu.amu.wmi.kino.netbeans.mvp.client.handlers.InputHandler;
import pl.edu.amu.wmi.kino.netbeans.mvp.client.handlers.OptionChooseHandler;
import pl.edu.amu.wmi.kino.netbeans.mvp.event.HandlerRegistration;

/**
 *
 * @author Patryk Żywica
 */
public interface EnumerationDisplay extends Display {

    public static final InputHandler.Input<String> EXPANDED_SEARCH_INPUT = new InputHandler.Input<String>();
    public static final OptionChooseHandler.OptionChooser EXPANDED_SEARCH_OPTION = new OptionChooseHandler.OptionChooser();
    public static final OptionChooseHandler.OptionChooser BASIC_SEARCH_OPTION = new OptionChooseHandler.OptionChooser();

    void setBasicOptions(Node[] nodes);

    void setSelected(Node node);

    void setExpandedOptions(Node rootNode, Node[] selectableNodes);

    void setLabel(String labelText);

    void showExpandedOptionsDialog();

    /**
     * Sets unique id, that describes what this display is displaying.
     * 
     * Used e.g. in properties as property name to distinguish between properties in set.
     * 
     * @param id 
     */
    void setId(String id);

    /**
     * Returns index of selected basic option (Node).
     * @param source 
     * @param h
     * @return
     */
    HandlerRegistration addOptionHandler(OptionChooseHandler.OptionChooser source, OptionChooseHandler h);

     <T> HandlerRegistration addInputHandler(InputHandler.Input<T> input, InputHandler<T> h);
}
