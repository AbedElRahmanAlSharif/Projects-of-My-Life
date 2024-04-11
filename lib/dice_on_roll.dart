import 'dart:math';
import 'dart:developer' as dev;

import 'package:flutter/material.dart';

class DiceOnRoll extends StatefulWidget {
  const DiceOnRoll({Key? key}) : super(key: key);

  @override
  State<DiceOnRoll> createState() => _DiceOnRollState();
}

class _DiceOnRollState extends State<DiceOnRoll> {
  
  final rand = Random();
  var activeDice = 'images\\dice-images\\dice-1.png';
void buttonPressed(){
  
  var random = rand.nextInt(6) + 1;
  setState((){
    activeDice = 'images\\dice-images\\dice-$random.png';
  });
  dev.log('Button Pressed');

}
@override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Dice',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: Scaffold(
        backgroundColor: const Color.fromARGB(255, 229, 226, 45), 
        appBar: AppBar(
          title: const Text('Dice'),
          centerTitle: true,
          backgroundColor:  const Color.fromARGB(255, 208, 211, 20),
          titleTextStyle: const TextStyle(
            fontSize: 30,
            fontWeight: FontWeight.bold,
          ),
        ),
        body:
        Center(
          child:  
          Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Image.asset( activeDice,  
              width: 200,
              height: 300,
              ),
              
              MaterialButton(onPressed: (){
                buttonPressed();
              }, 
            highlightColor: Colors.orangeAccent,
            splashColor:const Color.fromARGB(20, 40, 60, 0),
            color:const Color.fromARGB(255, 211, 65, 20),
            elevation: 10,
            shape: RoundedRectangleBorder(
              borderRadius: BorderRadius.circular(20),
            ),
            textColor:const Color.fromARGB(255, 0, 0, 0),
            child: const Text('Roll Dice',
            style: TextStyle(
              fontSize: 20,
              fontWeight: FontWeight.bold,
            ),
            ),
            ),
            ],
            ),
            ),
              ),
           );   
  }
}
