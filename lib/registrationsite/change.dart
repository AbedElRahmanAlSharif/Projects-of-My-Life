// ignore_for_file: must_be_immutable

import 'package:flutter/material.dart';
import 'package:todo_me/homescreen.dart';

class changePass extends StatelessWidget {
   changePass({super.key});
  final __formKey = GlobalKey<FormState>();
  RegExp regex = RegExp(r'^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[!@#\$&*~]).{8,}$');

  final _password = TextEditingController();
  final _cpassword = TextEditingController();
  @override
  Widget build(BuildContext context) {
    void _Change(){
      Navigator.push(context, MaterialPageRoute(builder: (context) => home_screen()));
    }
    return Scaffold(

      backgroundColor: const Color(0xEEEEEEEE),
      body: 
      Form(
        key: __formKey,
        
        child: SingleChildScrollView(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              Transform(
                transform: Matrix4.translationValues(-100, -120, 0),
                child: Container(
                  width: 300,
                  height: 233,
                  decoration: const BoxDecoration(
                    shape: BoxShape.circle,
                    color: Color.fromRGBO(156, 229, 224, 50),
                  ),
                ),
              ),
              Transform(
                transform: Matrix4.translationValues(-250, -280, 0),
                child: Container(
                  width: 300,
                  height: 233,
                  decoration: const BoxDecoration(
                    shape: BoxShape.circle,
                    color: Color.fromRGBO(156, 229, 224, 50),
                  ),
                ),
              ), 
              const Center(
                child:  Text(
            'Welcome Onboard',
            style: TextStyle(fontWeight: FontWeight.bold, fontSize: 25),
              ),
              ),
              const Center(
                 child:  Text(
            'Help us to help you',
              ),
              ),
             const SizedBox(height: 5),
              Container(
                 width: 310,
                height: 50,
                decoration: BoxDecoration(
                    color: Colors.white,
                    borderRadius: BorderRadius.circular(20),
                  ),
                child: TextFormField(
                  controller: _password,
                  decoration: const InputDecoration(
                    labelText: 'Password',
                    hintText: 'Enter your password',
                    border: InputBorder.none,
                    contentPadding: EdgeInsets.all(20.0),
                    floatingLabelBehavior: FloatingLabelBehavior.never,
                  ),
                  obscureText: true,
                  validator: (value) {
                    if (value == null || value.isEmpty) {
                      return 'Please enter some text';
                    }
                    if (!regex.hasMatch(value)) {
                      return 'Password must contain at least 8 characters, one uppercase, one lowercase, one number and one special character';
                    }
                    return null;
                  },
                  onSaved: (value) => _password.text = value!,
                ),
              ),
             const SizedBox(height: 15,),
              Container(
                width: 310,
                height: 50,
                decoration: BoxDecoration(
                    color: Colors.white,
                    borderRadius: BorderRadius.circular(20),
                  ),
                child: TextFormField(
                  controller: _cpassword,
                  decoration: const InputDecoration(
                    labelText: 'Confirm Password',
                    hintText: 'Enter your password again',
                    border: InputBorder.none,
                    contentPadding: EdgeInsets.all(20.0),
                    floatingLabelBehavior: FloatingLabelBehavior.never,
                  ),
                  obscureText: true,
                  validator: (value) {
                    if (value == null || value.isEmpty) {
                      return 'Please enter some text';
                    }
                    if (value != _password.text) {
                      return 'Password does not match';
                    }
                    else if(_cpassword == _password){
                      return 'Password does not match';
                    }
                    return null;
                  },
                  onSaved: (value) => _cpassword.text = value!,
                ),
              ),
              Padding(
                padding: const EdgeInsets.symmetric(vertical: 16.0),
                child: SizedBox( 
                  width: 310,
                  height: 60,
                  child: ElevatedButton(
                  onPressed: _Change,
                  style: ElevatedButton.styleFrom(
                    backgroundColor: const Color.fromRGBO(58, 190, 208, 75),
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(20),
                    ),
                  ),
                  child: const Text('Change' , style:  TextStyle(color:  Colors.white),),
                ),
              ),
              ),
              const SizedBox(height: 15,),
            ],
          ),
        ),
      ),
    );
  }
}