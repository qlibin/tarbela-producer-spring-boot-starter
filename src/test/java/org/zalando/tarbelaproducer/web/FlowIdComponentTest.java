package org.zalando.tarbelaproducer.web;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.zalando.tracer.Tracer;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FlowIdComponentTest {

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    Tracer tracer;

    @Test
    public void makeSureItWorks() {
        FlowIdComponent flowIdComponent = new FlowIdComponent(tracer);
        Mockito.when(tracer.get("X-Flow-ID").getValue()).thenReturn("A_FUNKY_VALUE");

        assertThat(flowIdComponent.getXFlowIdKey(), Matchers.equalTo("X-Flow-ID"));
        assertThat(flowIdComponent.getXFlowIdValue(), Matchers.equalTo("A_FUNKY_VALUE"));
    }

}