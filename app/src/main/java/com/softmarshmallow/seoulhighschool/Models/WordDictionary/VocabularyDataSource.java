package com.softmarshmallow.seoulhighschool.Models.WordDictionary;

import java.util.ArrayList;
import java.util.List;


public class VocabularyDataSource
{
        public static List<VocabularyModel> vocabularyModelList = new ArrayList<VocabularyModel>(){{
                add(
                        new VocabularyModel()
                        .setVocabTitle("뚝떨")
                        .setVocabDescription("뭘하든 뚝 떨어지는 사람")
                );
                add(
                        new VocabularyModel()
                                .setVocabTitle("C")
                                .setVocabDescription("C is for C#")
                );
                add(
                        new VocabularyModel()
                                .setVocabTitle("E")
                                .setVocabDescription("E is for Elephant")
                );
                
                //REAL DATA
        
                add(
                        new VocabularyModel()
                                .setVocabTitle("가, 나, 다 군")
                                .setVocabDescription("-4년제 대학에 해당하는 가군, 나군, 다군은 정시모집에서의 전형실시 기간에 따른 구분이다.\t정시 모집에서는 대학(교육대학 포함)마다 교육부가 구분한 시험기간 군(가,나,다군)이 정해져 있는데 시험기간 군이 다른 대학간 또는 동일대학내 시험기간군이 다른 모집단위(대학이 분할모집하는 경우)간에는 복수 지원이 가능하지만, 시험기간 군이 동일하면 한 곳만 선택하여 지원해야만 한다. 즉 수험생은 정시모집에서 가,나,다군 각 군별로 한 대학씩 3개 대학에만 지원할 수 있다.")
                );
        
                add(
                        new VocabularyModel()
                                .setVocabTitle("고교 등급제")
                                .setVocabDescription("-고교등급제는 고교간의 학력차를 입학 사정 때 반영하는 것으로 교육인적자원부는 고교 간 서열화를 우려해 이를 금지하고 있는 제도이다. 그러나 현재 서울 소재 일부 상위권 대학(연대,고대)들이 외국어고·과학고 등 특정고교 출신 학생에게 가산점을 주는 방식 등으로 사실상 비공식적으로 고교간 등급제를 실시하고 있는 실상이다.\n")
                );
                add(
                        new VocabularyModel()
                                .setVocabTitle("교과")
                                .setVocabDescription("-각 교과목의 성적을 의미한다.")
                );
                add(
                        new VocabularyModel()
                                .setVocabTitle("비교과")
                                .setVocabDescription("출결 및 봉사활동, 특별활동, 자격증, 수상경력 등의 교과 이외의 활동내역들을 의미한다.\n")
                );
                add(
                        new VocabularyModel()
                                .setVocabTitle("가산점")
                                .setVocabDescription("수능 성적을 반영할 때 모집단위별 기준에 따라 점수를 가/감하여 주는 것을 의미한다. \n" +
                                        "ex) 수학A형과 B 응시자 모두가 지원 할 수 있는 곳에서는 수학B형을 본 사람에게 가산점을 부여한다.")
                );
                add(
                        new VocabularyModel()
                                .setVocabTitle("구술 면접\n")
                                .setVocabDescription("구술 면접은 말로 하는 시험을 뜻한다. 통찰력과 논리적 사고력, 의사소통능력을 평가하는 시험이라고 할 수 있다. ")
                );
                add(
                        new VocabularyModel()
                                .setVocabTitle("논술")
                                .setVocabDescription("어떤 주제에 대해 논리적으로 서술하는 것을 뜻한다. 논술에는 학과 분류 방식에 따라 인문계 논술과 자연계 논술로 나뉜다.")
                );
                add(
                        new VocabularyModel()
                                .setVocabTitle("내신 등급제")
                                .setVocabDescription("학생부 성적을 1~9등급으로 나눈것을 의미한다.\n" +
                                "등급\t석차 백분율\n" +
                                        "(대상 인원)\n" +
                                        "1\t~4%이하(4%)\n" +
                                        "2\t4%초과~11%이하(7%)\n" +
                                        "3\t11%초과~23%이하(12%)\n" +
                                        "4\t23%초과~40%이하(17%)\n" +
                                        "5\t40%초과~60%이하(20%)\n" +
                                        "6\t60%초과~77%이하(17%)\n" +
                                        "7\t77%초과~89%이하(12%)\n" +
                                        "8\t89%초과~96%이하(7%)\n" +
                                        "9\t96%초과~100%이하(4%)")
                );
        
                add(
                        new VocabularyModel()
                                .setVocabTitle("단계별 사정\n")
                                .setVocabDescription("단계별 사정은 한번에 모든 합격자를 선발하는 것이 아니라 여러 단계를 거치면서 합격자를 발표하는 것을 말한다.\n" +
                                        "ex) 1단계:모집 정원의 220%를 수능성적만으로 선발 → 1차 합격 \u20282단계:모집 정원의 15%를 수능 특정 영역 점수만으로 선발\u20283단계:모집 정원의 40%를 학생부, 수능, 논술고사 성적을 합산하여 선발 → 최종 합격\n")
                );
        
        
                add(
                        new VocabularyModel()
                                .setVocabTitle("대학 정보 공시제\n")
                                .setVocabDescription("대학은 교원확보율, 신입생 충원율, 취업률, 재정현황, 교원의 연구 및 교육 등 교육·연구에 관한 주요 정보를 학교인터넷 홈페이지에 올리거나 쉽게 해당 정보에 접근·열람할 수 있는 적절한 방법으로 학생들에게 알려야 한다.")
                );
        
        
                add(
                        new VocabularyModel()
                                .setVocabTitle("독학사 제도")
                                .setVocabDescription(" 독학사 제도란 고등학교 졸업이상의 학력을 가지고 시간적 제약이나 경제적 사정으로 인하여 대학에 진학하지 못한 사람이 스스로 독학하거나, 자습을 통하여 국가가 시행하는 4단계 시험에 모두 합격하였을 시 학사학위를 취득하는 제도를 의미한다.")
                );
        
        
                add(
                        new VocabularyModel()
                                .setVocabTitle("대학별 독자기준 특별전형")
                                .setVocabDescription("대학 독자적기준에 의한 특별전형은 그해 대학의 교육목적과 사회통념적 가치기준에 해당하는 자로서 학장이 정하는 기준에 해당하는 자를 대상으로 실시하는 정원내 특별전형을 뜻한다. ")
                );
        
        
                add(
                        new VocabularyModel()
                                .setVocabTitle(" 모집 단위")
                                .setVocabDescription("수험생이 지원할 대학교의 최소단위를 의미한다.\n")
                );
        
        
                add(
                        new VocabularyModel()
                                .setVocabTitle("모집인원 유동제")
                                .setVocabDescription("대학에서 합격자 발표시 합격선에 일부 동점자가 발생한 경우 동점자에 한하여 모집 예정 인원보다 초과 모집할 수 있게 하는 제도를 뜻한다.")
                );
        
        
        
                add(
                        new VocabularyModel()
                                .setVocabTitle("백분위")
                                .setVocabDescription("각 수험생의 상대적 순위을 나타내는 지수이다. 한 수험생보다 낮은 점수를 받은 수험생의 백분율을 말합니다.")
                );
        
                add(
                        new VocabularyModel()
                                .setVocabTitle("복수전공")
                                .setVocabDescription("학생이 입학한 모집단위에서 최초로 배정 받은 학과 또는 전공을 포함하여 2개 이상의 학과 또는 전공(연계전공포함)을 이수하는 것을 의미한다.")
                );
        
                add(
                        new VocabularyModel()
                                .setVocabTitle("복수 지원제")
                                .setVocabDescription("정시 모집 대학(교육대학 포함)에 있어서 교육부가 구분한 시험기간 군(가, 나, 다군)이 다른 대학간 또는 동일대학 내 시험기간 군이 다른 모집단위(대학이 분할 모집하는 경우)간에는 여러 번 대학에 지원이 가능하다. 이것을 복수지원이라고 한다.\n")
                );
        
                add(
                        new VocabularyModel()
                                .setVocabTitle("부전공")
                                .setVocabDescription("부전공이란 학생이 소속한 전공(학과)이외의 전공(학과)에서 정해진 일정 학점 이상을 이수하는 것이다. 두 개의 전공학위를 받지는 못하지만 제1전공에 이어 다른 전공을 좀더 깊이 있게 공부하고 싶은 학생들에게 주어지는 기회를 의미한다.")
                );
        
                add(
                        new VocabularyModel()
                                .setVocabTitle("부랄모집")
                                .setVocabDescription("-정시모집시 한 대학에서 학과를 2개 이상의 군으로 분할해서 모집하는 경우를 말한다. \n" +
                                        "Ex) 한 대학의 의예과와 치의예과는 정시 \"\"가\"\"군에서 모집하고, 나머지 학과들은 정시\"\"다\"\"군에서 모집하는 경우가 이런 경우에 속한다.")
                );
        
                add(
                        new VocabularyModel()
                                .setVocabTitle("사이버 대학")
                                .setVocabDescription("- 사이버대학이란 세계적인 통신망인 인터넷을 이용, 실제 교실에서 이루어지는 것과 똑같은 강의를 컴퓨터 화상을 통해서 들을 수 있는 가상공간에 세워지는 대학을 뜻한다.")
                );
        
                add(
                        new VocabularyModel()
                                .setVocabTitle("선택 과목제")
                                .setVocabDescription("- 사회·과학·직업탐구영역의 경우, 수험생이 직접 여러 과목 가운에 자유롭게 선택과목을 지정해 응시할 수 있도록 하고 있는 제도이다.\n" +
                                        "Ex) 사회탐구영역은 11개 과목 중 최대 4과목 선택할 수 있으며, 과학탐구영역은 8개 과목 중 최대 4과목을 선택\n")
                );
        
                add(
                        new VocabularyModel()
                                .setVocabTitle("실질 반영 비율")
                                .setVocabDescription("학생부 실질반영비율이란 실제적으로 학생부가 전형총점에 대하여 미치는 비율을 말한다.\n")
                );
        
                add(
                        new VocabularyModel()
                                .setVocabTitle("우선선발")
                                .setVocabDescription("대학이 해당 전형에서 우수한 학생을 먼저 선발하기 위해 만든 제도이다.\n")
                );
        
                add(
                        new VocabularyModel()
                                .setVocabTitle("원점수")
                                .setVocabDescription("원점수는 정답한 문항에 부여된 배점을 단순히 합산한 점수를 의미한다. ")
                );
        
                add(
                        new VocabularyModel()
                                .setVocabTitle("입학사정관제")
                                .setVocabDescription("입학사정관이라는 전문인력이  특정영역의 우수인재 선발 전권을 행사하는 것을 뜻한다. 이는 학생들의 선택과 집중을 유도하는 또 하나의 제도다.")
                );
        
                add(
                        new VocabularyModel()
                                .setVocabTitle("자율전공제")
                                .setVocabDescription("자율전공은 수험생 중 학과나 전공을 택하지 못했거나, 진로가 불투명한 학생들이 1년간의 진로탐색과정을 거친 후 자신의 적성을 찾아 인원에 관계없이 전공을 선택하는 제도이다.")
                );
        
                add(
                        new VocabularyModel()
                                .setVocabTitle("전공 적성검사")
                                .setVocabDescription("주로 중하위권 대학에서 학업 적성이나 자질을 검사하는 시험을 의미한다.")
                );
        
                add(
                        new VocabularyModel()
                                .setVocabTitle("표준점수")
                                .setVocabDescription("동일한 영역이나 과목을 치른 응시자 집단에서 해당 수험생의 상대적인 성취수준을 나타내는 점수를 의미한다.")
                );
        
                add(
                        new VocabularyModel()
                                .setVocabTitle("학생부")
                                .setVocabDescription("학생부란 학교생활기록부의 줄임말로 고등학교 내신성적을 뜻한다")
                );
        
                add(
                        new VocabularyModel()
                                .setVocabTitle("표준편차")
                                .setVocabDescription("표준점수는 각 개인의 원점수가 평균으로부터 떨어진 거리를 표준편차의 단위로 하여 나타낸 점수를 의미한다")
                );
        
        }};
}
