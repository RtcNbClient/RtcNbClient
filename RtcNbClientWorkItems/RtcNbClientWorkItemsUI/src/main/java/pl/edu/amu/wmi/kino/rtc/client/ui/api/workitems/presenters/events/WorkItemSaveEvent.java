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
package pl.edu.amu.wmi.kino.rtc.client.ui.api.workitems.presenters.events;

import org.openide.util.Lookup;
import pl.edu.amu.wmi.kino.netbeans.mvp.event.EventBus;
import pl.edu.amu.wmi.kino.netbeans.mvp.event.EventHandler;
import pl.edu.amu.wmi.kino.netbeans.mvp.event.HandlerRegistration;
import pl.edu.amu.wmi.kino.netbeans.mvp.event.MvpEvent;
import pl.edu.amu.wmi.kino.netbeans.mvp.event.MvpEvent.Type;
import pl.edu.amu.wmi.kino.rtc.client.ui.api.workitems.presenters.events.WorkItemSaveEvent.WorkItemSaveHandler;

/**
 *
 * @author Patryk Żywica
 */
public class WorkItemSaveEvent extends MvpEvent<WorkItemSaveHandler> {

    private static Type<WorkItemSaveHandler> TYPE = new Type<WorkItemSaveHandler>();

    @Override
    public Type<WorkItemSaveHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(WorkItemSaveHandler handler) {
        handler.workItemSaved();
    }

    public static HandlerRegistration register(WorkItemSaveHandler h, Object source) {
        return Lookup.getDefault().lookup(EventBus.class).addHandlerToSource(TYPE, source, h);
    }

    public interface WorkItemSaveHandler extends EventHandler {

        void workItemSaved();
    }
}
