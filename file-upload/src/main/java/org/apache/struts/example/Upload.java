/*
 * $Id$
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.struts.example;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.*;

import java.io.*;
import java.nio.file.*;
import java.nio.charset.*;
import java.util.*;

/**
 * <code>Allows upload a file</code>
 */
public class Upload extends ActionSupport {
    static final Logger LOG = LogManager.getLogger(Upload.class);

    private File[] upload;
    private String[] uploadFileName;
    private String[] uploadContentType;

    public String execute() throws Exception {
        LOG.info("RUN");
        if (upload != null) {
            for(File file : upload) {
                LOG.info(file.toString());
                Path path = Paths.get(file.getPath());
                List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
                LOG.info(allLines.toString());
            }
        }
        return INPUT;
    }

    public File[] getUpload() {
        return upload;
    }

    public void setUpload(File[] upload) {
        this.upload = upload;
    }

    public String[] getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String[] uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String[] getUploadContentType() {
        return uploadContentType;
    }

    public void setUploadContentType(String[] uploadContentType) {
        this.uploadContentType = uploadContentType;
    }
}
