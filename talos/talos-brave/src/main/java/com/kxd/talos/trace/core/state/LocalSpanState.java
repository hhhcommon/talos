/**
 *  Copyright 2013 <kristofa@github.com>
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 *  Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.kxd.talos.trace.core.state;

import com.kxd.talos.trace.core.span.Span;
import com.kxd.talos.trace.core.utils.Nullable;

/**
 * Maintains state for a single local span. This means nesting is not supported.
 *
 * <p/>Local spans can be at the following locations in the span tree.
 * <ul>
 *     <li>The root-span of a trace originated by Brave</li>
 *     <li>A child of a server span originated by Brave</li>
 * </ul>
 */
public interface LocalSpanState extends CommonSpanState {

    /**
     * Gets the Span for the local request that was started as part of current request.
     * <p/>
     * Should be thread-aware to support multiple parallel requests.
     * 
     * @return Local request span for current thread.
     */
    @Nullable
	Span getCurrentLocalSpan();

    /**
     * Sets current local span.
     * <p/>
     * Should be thread-aware to support multiple parallel requests.
     * 
     * @param span Local span.
     */
    void setCurrentLocalSpan(Span span);
    
    Span getPrefixLocalSpan();
    
    void setPrefixLocalSpan(Span span);
}
