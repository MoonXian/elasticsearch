/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License
 * 2.0; you may not use this file except in compliance with the Elastic License
 * 2.0.
 */

package org.elasticsearch.xpack.core.ml.action;

import org.elasticsearch.test.ESTestCase;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class GetDataFrameAnalyticsStatsActionRequestTests extends ESTestCase {

    public void testRequest_GivenNoId() {
        GetDataFrameAnalyticsStatsAction.Request request = new GetDataFrameAnalyticsStatsAction.Request();
        assertThat(request.getId(), notNullValue());
        assertThat(request.getId(), equalTo("_all"));
    }

    public void testSetId_GivenNull() {
        GetDataFrameAnalyticsStatsAction.Request request = new GetDataFrameAnalyticsStatsAction.Request();
        expectThrows(IllegalArgumentException.class, () -> request.setId(null));
    }

    public void testSetId_GivenString() {
        GetDataFrameAnalyticsStatsAction.Request request = new GetDataFrameAnalyticsStatsAction.Request();

        request.setId("foo");

        assertThat(request.getId(), equalTo("foo"));
    }

    public void testSetAllowNoMatch() {
        GetDataFrameAnalyticsStatsAction.Request request = new GetDataFrameAnalyticsStatsAction.Request();
        assertThat(request.isAllowNoMatch(), is(true));
        request.setAllowNoMatch(false);
        assertThat(request.isAllowNoMatch(), is(false));
    }
}
