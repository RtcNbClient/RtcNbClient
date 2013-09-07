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
package pl.edu.amu.wmi.kino.rtc.client.facade.impl.common.process;

import com.ibm.team.repository.client.IItemManager;
import com.ibm.team.repository.client.ITeamRepository;
import com.ibm.team.repository.common.TeamRepositoryException;
import com.ibm.team.workitem.common.model.IDeliverable;
import com.ibm.team.workitem.common.model.IDeliverableHandle;
import java.util.Date;
import pl.edu.amu.wmi.kino.rtc.client.facade.api.common.process.Deliverable;

/**
 *
 * @author Patryk Żywica
 */
public class DeliverableImpl implements Deliverable {

    private IDeliverable deliverable;

    DeliverableImpl(IDeliverableHandle deliverableHandle) {
        if (deliverableHandle.hasFullState()) {
            this.deliverable = (IDeliverable) deliverableHandle.getFullState();
        } else {
            if (deliverableHandle instanceof IDeliverable) {
                this.deliverable = (IDeliverable) deliverableHandle;
            } else {
                try {
                    this.deliverable = (IDeliverable) ((ITeamRepository) deliverableHandle.getOrigin()).itemManager().fetchCompleteItem(deliverableHandle, IItemManager.DEFAULT, null);
                } catch (TeamRepositoryException ex) {
                    throw new IllegalArgumentException(ex);
                }
            }
        }
    }

    public String getName() {
        return deliverable.getName();
    }

    public String getHTMLDescription() {
        return deliverable.getHTMLDescription().getXMLText();
    }

    public Date getCreationDate() {
        return deliverable.getCreationDate();
    }

    public boolean isArchived() {
        return deliverable.isArchived();
    }
    
    public IDeliverable getIDeliverable(){
        return deliverable;
    }
}
