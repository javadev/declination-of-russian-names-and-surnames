/*
 * $Id$
 *
 * Copyright 2014 Valentyn Kolesnikov
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
package com.github.declinationofnames;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RussianNameTest {

    @Test
    public void common_form_converter() {
        // годится обычная форма
        RussianName name = new RussianName("Козлов Евгений Павлович");
        assertEquals("Козлова Евгения Павловича", name.fullName(RussianNameProcessor.gcaseRod));
        assertEquals("Козлову Евгению Павловичу", name.fullName(RussianNameProcessor.gcaseDat));
        assertEquals("Козлова Евгения Павловича", name.fullName(RussianNameProcessor.gcaseVin));
        assertEquals("Козловым Евгением Павловичем", name.fullName(RussianNameProcessor.gcaseTvor));
        assertEquals("Козлове Евгении Павловиче", name.fullName(RussianNameProcessor.gcasePred));
    }

    @Test
    public void name_first_converter() {
        // в таком виде тоже
        RussianName name = new RussianName("Евгений Павлович Козлов");
        assertEquals("Козлова Евгения Павловича", name.fullName(RussianNameProcessor.gcaseRod));
        assertEquals("Козлову Евгению Павловичу", name.fullName(RussianNameProcessor.gcaseDat));
        assertEquals("Козлова Евгения Павловича", name.fullName(RussianNameProcessor.gcaseVin));
        assertEquals("Козловым Евгением Павловичем", name.fullName(RussianNameProcessor.gcaseTvor));
        assertEquals("Козлове Евгении Павловиче", name.fullName(RussianNameProcessor.gcasePred));
    }

    @Test
    public void surname_and_name_converter() {
        // можно явно указать составляющие
        RussianName name = new RussianName("Козлов", "Евгений", null, null);
        assertEquals("Козлова Евгения", name.fullName(RussianNameProcessor.gcaseRod));
        assertEquals("Козлову Евгению", name.fullName(RussianNameProcessor.gcaseDat));
        assertEquals("Козлова Евгения", name.fullName(RussianNameProcessor.gcaseVin));
        assertEquals("Козловым Евгением", name.fullName(RussianNameProcessor.gcaseTvor));
        assertEquals("Козлове Евгении", name.fullName(RussianNameProcessor.gcasePred));
    }

    @Test
    public void surname_and_name_with_gender_converter() {
        // можно явно указать пол ('m' или 'f')
        RussianName name = new RussianName("Кунтидия", "Убиреко", "", "f");
        assertEquals("Кунтидия Убиреко", name.fullName(RussianNameProcessor.gcaseRod));
        assertEquals("Кунтидия Убиреко", name.fullName(RussianNameProcessor.gcaseDat));
        assertEquals("Кунтидия Убиреко", name.fullName(RussianNameProcessor.gcaseVin));
        assertEquals("Кунтидия Убиреко", name.fullName(RussianNameProcessor.gcaseTvor));
        assertEquals("Кунтидия Убиреко", name.fullName(RussianNameProcessor.gcasePred));
    }
}
