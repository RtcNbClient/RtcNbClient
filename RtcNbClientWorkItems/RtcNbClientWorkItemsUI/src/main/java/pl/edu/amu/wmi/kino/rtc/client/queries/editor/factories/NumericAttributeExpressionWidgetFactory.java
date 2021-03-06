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
package pl.edu.amu.wmi.kino.rtc.client.queries.editor.factories;

import org.netbeans.api.visual.widget.Scene;
import org.netbeans.api.visual.widget.Widget;
import org.openide.util.lookup.ServiceProvider;
import pl.edu.amu.wmi.kino.rtc.client.queries.editor.api.AbstractAttributeExpressionWidgetFactory;
import pl.edu.amu.wmi.kino.rtc.client.queries.editor.api.AttributeExpressionWidgetFactory;
import pl.edu.amu.wmi.kino.rtc.client.queries.editor.factories.widgets.StringMultiValueEditorWidget;
import pl.edu.amu.wmi.kino.rtc.client.queries.model.attributes.values.RtcQueryAttributeNumericValueChecker;
import pl.edu.amu.wmi.kino.rtc.client.queries.model.expression.editable.RtcEditableAttributeExpression;
import pl.edu.amu.wmi.kino.rtc.client.queries.model.query.RtcQuery;

/**
 *
 * @author Patryk Żywica
 */
@ServiceProvider(service = AttributeExpressionWidgetFactory.class, path = "Rtc/Modules/QueriesModule/AttributeExpressionWidgetFactories")
public class NumericAttributeExpressionWidgetFactory extends AbstractAttributeExpressionWidgetFactory {

    @Override
    public boolean canCreate(RtcEditableAttributeExpression expression,RtcQuery query) {
        return expression.getQueryAttribute().getLookup().lookup(RtcQueryAttributeNumericValueChecker.class) != null;
    }

    @Override
    public Widget createDescription(RtcEditableAttributeExpression expression,RtcQuery query, Scene scene) {
        return new StringMultiValueEditorWidget(
                scene,
                expression,
                expression.getQueryAttribute().getLookup().lookup(RtcQueryAttributeNumericValueChecker.class));
    }

    @Override
    public boolean canCreateValueWidgets(RtcEditableAttributeExpression expression,RtcQuery query) {
        return false;
    }

    @Override
    public boolean canCreateVariableWidgets(RtcEditableAttributeExpression expression,RtcQuery query) {
        return false;
    }
}
