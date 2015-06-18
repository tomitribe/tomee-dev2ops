/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.supertribe;

import org.tomitribe.crest.api.Command;
import org.tomitribe.crest.connector.api.CrestListener;
import org.tomitribe.util.PrintString;

import javax.ejb.MessageDriven;

@MessageDriven
public class Fun implements CrestListener {

    @Command
    public String thankyou(final String name) {

        final PrintString out = new PrintString();
        out.printf("Thank you very much, %s!", name);
        out.printf("%nHope you enjoyed!%n");
        out.printf("David Blevins%n%n");
        out.printf("\033[38;5;130mTomi\033[0m\033[38;5;124mtribe\033[0m%n");

        return out.toString();
    }
}
