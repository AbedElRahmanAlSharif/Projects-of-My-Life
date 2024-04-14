import 'package:flutter/material.dart';
// import 'package:todo_me/registrationsite/Signin.dart';
import 'package:todo_me/homescreen.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    
    return const MaterialApp(
      title: 'Do it you can',   
      debugShowCheckedModeBanner: false,
      home: home_screen(),
    );
  }
}
