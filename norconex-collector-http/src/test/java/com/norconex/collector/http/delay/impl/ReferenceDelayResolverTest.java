/* Copyright 2016 Norconex Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.norconex.collector.http.delay.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.norconex.collector.http.delay.impl.ReferenceDelayResolver.DelayReferencePattern;
import com.norconex.commons.lang.config.ConfigurationUtil;

public class ReferenceDelayResolverTest {

    @Test
    public void testWriteRead() throws IOException {
        ReferenceDelayResolver r = new ReferenceDelayResolver();
        r.setDefaultDelay(10000);
        r.setIgnoreRobotsCrawlDelay(true);
        r.setScope("thread");
        List<DelayReferencePattern> delayPatterns = new ArrayList<>();
        delayPatterns.add(new DelayReferencePattern(
                "http://example\\.com/.*", 1000));
        r.setDelayReferencePatterns(delayPatterns);

        System.out.println("Writing/Reading this: " + r);
        ConfigurationUtil.assertWriteRead(r);
    }

}