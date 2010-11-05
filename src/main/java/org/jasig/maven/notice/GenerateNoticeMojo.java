/**
 * Licensed to Jasig under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Jasig licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a
 * copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.jasig.maven.notice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.logging.Log;
import org.jasig.maven.notice.util.ResourceFinder;

/**
 * Generates the NOTICE file
 * 
 * @author Eric Dalquist
 * @version $Revision$
 * @goal generate
 * @threadSafe true
 * @requiresDependencyResolution test
 */
public class GenerateNoticeMojo extends AbstractNoticeMojo {
    
    @Override
    protected void handleNotice(Log logger, ResourceFinder finder, String noticeContents) throws MojoFailureException {
        
        //Write out the generated notice file
        final File outputFile = getNoticeOutputFile();
        try {
            FileUtils.writeStringToFile(outputFile, noticeContents, this.encoding);
        }
        catch (IOException e) {
            throw new MojoFailureException("Failed to write NOTICE File to: " + outputFile, e);
        }
    }
}
