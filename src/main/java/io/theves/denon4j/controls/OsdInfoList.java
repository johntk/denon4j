/*
 * Copyright 2017 Sascha Theves
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package io.theves.denon4j.controls;


import io.theves.denon4j.net.Event;

import java.nio.charset.Charset;
import java.util.*;

/**
 * Represents the Onscreen Display Information List that is sent back for 'NSE' and 'NSA' commands.
 *
 * @author stheves
 */
public class OsdInfoList {
    private final List<Line> lines;
    private final Charset charset;

    public OsdInfoList(Charset charset) {
        this.lines = new ArrayList<>();
        this.charset = charset;
    }

    public void addEvent(Event event) {
        Line line = new Line(event, charset);
        lines.add(line.getIndex(), line);
    }

    public Line lineAt(int index) {
        return lines.get(index);
    }

    public Line cursorLine() {
        return lines.stream()
            .filter(Line::isCursorSelect).findFirst().orElse(null);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        getLines().forEach(line -> builder.append(line.getDisplayLine()).append(System.lineSeparator()));
        return builder.toString();
    }

    public List<Line> getLines() {
        List<Line> lines = new ArrayList<>(this.lines);
        Collections.sort(lines);
        return lines;
    }
}
