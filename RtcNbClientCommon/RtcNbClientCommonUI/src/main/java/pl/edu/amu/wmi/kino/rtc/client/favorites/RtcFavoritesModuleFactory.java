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
package pl.edu.amu.wmi.kino.rtc.client.favorites;

import org.openide.nodes.Node;
import org.openide.util.lookup.InstanceContent;
import org.openide.util.lookup.ServiceProvider;
import pl.edu.amu.wmi.kino.rtc.client.connections.api.RtcIndependentModuleFactory;
import pl.edu.amu.wmi.kino.rtc.client.favorites.nodes.RtcFavoritesNode;

/**
 *
 * @author Patryk Żywica
 */
@ServiceProvider(service=RtcIndependentModuleFactory.class,path="Rtc/Modules/IndependentNodeFactories")
public class RtcFavoritesModuleFactory implements RtcIndependentModuleFactory {

    @Override
    public Node[] createModuleNodes() {
        InstanceContent ic = new InstanceContent();
        return new Node[]{new RtcFavoritesNode(ic)};
    }
}
