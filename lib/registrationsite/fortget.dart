import 'package:flutter/material.dart';
import 'package:todo_me/registrationsite/Signin.dart';
import 'package:todo_me/registrationsite/change.dart';

class fpassword extends StatelessWidget {
   fpassword({super.key});
  final __formKey = GlobalKey<FormState>();

  final email = TextEditingController();

  @override
  Widget build(BuildContext context) {
    void _Check(){
    if(__formKey.currentState!.validate()){
      //! Save the form
      Navigator.push(context, MaterialPageRoute(builder: (context) =>  changePass()
      ),
      );
    }
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
             const SizedBox(height: 5),
              Center(
                child: Image.network('Pictures/undraw_access_account_re_8spm.svg'),
              ),
              Center(
                child: Container(
                   width: 310,
                  height: 50,
                  decoration: BoxDecoration(
                    color: Colors.white,
                    borderRadius: BorderRadius.circular(20),
                  ),
                  child: TextFormField(
                    controller: email,
                    decoration: const InputDecoration(
                      labelText: 'Email',
                      hintText: 'Enter your email',
                      border: InputBorder.none,
                      contentPadding: EdgeInsets.all(20.0),
                      floatingLabelBehavior: FloatingLabelBehavior.never,
                    ),
                    validator: (value) {
                      if (value == null || value.isEmpty) {
                        return 'Please enter some text';
                      }
                      if (!value.contains('@')) {
                        return 'Please enter a valid email';
                      }
                      return null;
                    },
                    onSaved: (value) => email.text = value!,
                  ),
                ),
              ),
             const  SizedBox(height: 15),
              Padding(
                padding: const EdgeInsets.symmetric(vertical: 16.0),
                child: SizedBox( 
                  width: 310,
                  height: 60,
                  child: ElevatedButton(
                  onPressed: _Check,
                  style: ElevatedButton.styleFrom(
                    backgroundColor: const Color.fromRGBO(58, 190, 208, 75),
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(20),
                    ),
                  ),
                  child: const Text('Send' , style:  TextStyle(color:  Colors.white),),
                ),
              ),
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  const Text(
                    'Don\'t have an account?',
                  ),
                  TextButton(
                    onPressed: () {
                      Navigator.push(
                        context,
                        MaterialPageRoute(builder: (context) => const Signin()),
                      );
                    },
                    child: const Text('Sign up'),
                  ),
                ],
              ),
            ],
          ),
        ),
      ),
    );
  }
}