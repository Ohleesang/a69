package com.example.a69

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        class Solution {
            var typedMap = mutableMapOf<String,Int>()
            fun initMap(){
                typedMap.put("R",0)
                typedMap.put("T",0)

                typedMap.put("C",0)
                typedMap.put("F",0)

                typedMap.put("J",0)
                typedMap.put("M",0)

                typedMap.put("A",0)
                typedMap.put("N",0)
            }

            fun choiceValue(n:Int):Int{
                var answer = 0
                when(n){
                    1 ->answer =-3
                    2 ->answer =-2
                    3 ->answer =-1
                    4 ->answer = 0
                    5 ->answer = 1
                    6 ->answer = 2
                    7 ->answer = 3
                }
                return answer
            }
            fun solution(survey: Array<String>, choices: IntArray): String {
                // 성격유형이 크게 4개,세부적으로 8개로나뉜다
                // survey 에서 성격유형을 입력받는다.
                // choices의 값(1~7)을 입력받아 survey에 값을 매긴다
                // 총 계산된 점수를 비교하여 성격유형을 리턴
                var answer: String = ""
                initMap()

                //RT CF JM AN 이 한쌍 이다
                //1~3 4 5~7 ...-3 -2 -1 0 1 2 3
                //choice 값이 양수 음수에따라 값을계산한다
                var value = 0
                for(i in survey.indices){
                    value = choiceValue(choices[i])
                    if(value<0){
                        typedMap.set(survey[i][0]+"",typedMap.getValue(survey[i][0]+"")-value)
                    }
                    else if(value>0){
                        typedMap.set(survey[i][1]+"",typedMap.getValue(survey[i][1]+"")+value)
                    }
                }
                //저장된 맵에 값을 비교하여 큰것을 문자열에 추가한후 출력
                if(typedMap.getValue("R")>=typedMap.getValue("T")) answer += "R"
                else answer += "T"

                if(typedMap.getValue("C")>=typedMap.getValue("F")) answer += "C"
                else answer += "F"

                if(typedMap.getValue("J")>=typedMap.getValue("M")) answer += "J"
                else answer += "M"

                if(typedMap.getValue("A")>=typedMap.getValue("N")) answer += "A"
                else answer += "N"


                return answer
            }
        }
        var a = Solution()
        a.solution(arrayOf("AN","CF","MJ","RT","NA"), intArrayOf(5,3,2,7,5))
        a.solution(arrayOf("TR","RT","TR"), intArrayOf(7,1,3))
    }
}