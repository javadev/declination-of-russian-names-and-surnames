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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Declinates of Russian names and surnames.
 *
 * @author Valentyn Kolesnikov
 * @version $Revision$ $Date$
 */
public class RussianNameProcessor {
    static String sexM = "m";
    static String sexF = "f";
    // именительный
    static String gcaseIm =   "nominative";
    static String gcaseNom = "nominative";
    // родительный
    static String gcaseRod =  "genitive";
    static String gcaseGen = "genitive";
    // дательный
    static String gcaseDat =  "dative";
    // винительный
    static String gcaseVin =  "accusative";
    static String gcaseAcc = "accusative";
    // творительный
    static String gcaseTvor = "instrumentative";
    static String gcaseIns = "instrumentative";
    // предложный
    static String gcasePred = "prepositional";
    static String gcasePos = "prepositional";
    
    static Map rules = new HashMap() {{
        put("lastName", new HashMap() {{
            put("exceptions", new ArrayList() {{
                add("	дюма,тома,дега,люка,ферма,гамарра,петипа,шандра . . . . .");
                add("	гусь,ремень,камень,онук,богода,нечипас,долгопалец,маненок,рева,кива . . . . .");
                add("	вий,сой,цой,хой -я -ю -я -ем -е");
            }});
            put("suffixes", new ArrayList() {{
                add("f	б,в,г,д,ж,з,й,к,л,м,н,п,р,с,т,ф,х,ц,ч,ш,щ,ъ,ь . . . . .");
                add("f	ска,цка  -ой -ой -ую -ой -ой");
                add("f	ая       --ой --ой --ую --ой --ой");
                add("	ская     --ой --ой --ую --ой --ой");
                add("f	на       -ой -ой -у -ой -ой");
				
                add("	иной -я -ю -я -ем -е");
                add("	уй   -я -ю -я -ем -е");
                add("	ца   -ы -е -у -ей -е");
					
                add("	рих  а у а ом е");
		
                add("	ия                      . . . . .");
                add("	иа,аа,оа,уа,ыа,еа,юа,эа . . . . .");
                add("	их,ых                   . . . . .");
                add("	о,е,э,и,ы,у,ю           . . . . .");
		
                add("	ова,ева            -ой -ой -у -ой -ой");
                add("	га,ка,ха,ча,ща,жа  -и -е -у -ой -е");
                add("	ца  -и -е -у -ей -е");
                add("	а   -ы -е -у -ой -е");
		
                add("	ь   -я -ю -я -ем -е");
		
                add("	ия  -и -и -ю -ей -и");
                add("	я   -и -е -ю -ей -е");
                add("	ей  -я -ю -я -ем -е");
		
                add("	ян,ан,йн   а у а ом е");
		
                add("	ынец,обец  --ца --цу --ца --цем --це");
                add("	онец,овец  --ца --цу --ца --цом --це");
		
                add("	ц,ч,ш,щ   а у а ем е");
		
                add("	ай  -я -ю -я -ем -е");
                add("	гой,кой  -го -му -го --им -м");
                add("	ой  -го -му -го --ым -м");
                add("	ах,ив   а у а ом е");
		
                add("	ший,щий,жий,ний  --его --ему --его -м --ем");
                add("	кий,ый   --ого --ому --ого -м --ом");
                add("	ий       -я -ю -я -ем -и");
					
                add("	ок  --ка --ку --ка --ком --ке");
                add("	ец  --ца --цу --ца --цом --це");
					
                add("	в,н   а у а ым е");
                add("	б,г,д,ж,з,к,л,м,п,р,с,т,ф,х   а у а ом е");                
            }});
        }});
        put("firstName", new HashMap() {{
            put("exceptions", new ArrayList() {{
                add("	лев    --ьва --ьву --ьва --ьвом --ьве");
                add("	павел  --ла  --лу  --ла  --лом  --ле");
                add("m	шота   . . . . .");
                add("m	пётр   ---етра ---етру ---етра ---етром ---етре");
                add("f	рашель,нинель,николь,габриэль,даниэль   . . . . .");
            }});
            put("suffixes", new ArrayList() {{
                add("	е,ё,и,о,у,ы,э,ю   . . . . .");
                add("f	б,в,г,д,ж,з,й,к,л,м,н,п,р,с,т,ф,х,ц,ч,ш,щ,ъ   . . . . .");

                add("f	ь   -и -и . ю -и");
                add("m	ь   -я -ю -я -ем -е");

                add("	га,ка,ха,ча,ща,жа  -и -е -у -ой -е");
                add("	а   -ы -е -у -ой -е");
                add("	ия  -и -и -ю -ей -и");
                add("	я   -и -е -ю -ей -е");
                add("	ей  -я -ю -я -ем -е");
                add("	ий  -я -ю -я -ем -и");
                add("	й   -я -ю -я -ем -е");
                add("	б,в,г,д,ж,з,к,л,м,н,п,р,с,т,ф,х,ц,ч	 а у а ом е");
            }});
        }});
        put("middleName", new HashMap() {{
            put("suffixes", new ArrayList() {{
                add("	ич   а  у  а  ем  е");
                add("	на  -ы -е -у -ой -е");
            }});
        }});
    }};

    /**
     */
    public RussianNameProcessor() {
    }
}
