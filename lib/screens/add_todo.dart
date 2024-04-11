import 'package:flutter/material.dart';
import 'package:hivedb/modules/Todo.dart';
import 'package:hive/hive.dart';

// ignore: must_be_immutable, use_key_in_widget_constructors
class Addtodo extends StatelessWidget {
  TextEditingController titleController = TextEditingController();
  TextEditingController descriptionController = TextEditingController();
  TextEditingController dateController = TextEditingController();
  TextEditingController timeController = TextEditingController();
  Box todoBox = Hive.box("todo");
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(),
      body: Padding(padding: const EdgeInsets.all(20),
          child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          TextField(
            controller: titleController,
            decoration: const InputDecoration(
              labelText: "Enter the title",
              border: OutlineInputBorder(),
            ),
          ),
          const SizedBox(
            height: 50,
            width: double.infinity,
          ),
          TextField(
            controller: descriptionController,
            decoration: const InputDecoration(
              labelText: "Enter the description",
              border: OutlineInputBorder(),
            ),  
          ),
          SizedBox(
            height: 50,
            width: double.infinity,
          ),
          TextFormField(
            controller: dateController,
            decoration: const InputDecoration(
              labelText: "Enter the date",
              border: OutlineInputBorder(),
              
            ),
            onTap: (){
              FocusScope.of(context).requestFocus(FocusNode());
              showDatePicker(context: context, initialDate: DateTime.now(),firstDate: DateTime.now(), lastDate: DateTime(2200));
            },
          ),
         const SizedBox(height: 30,),
          SizedBox(
            height: 50,
            width: double.infinity,
            child: ElevatedButton(
              onPressed: (){
                if(titleController.text.isNotEmpty){
                  Todo newTodo = Todo(
                    title: titleController.text,
                    description: "This is a description",
                    date: DateTime.now(),
                    time: DateTime.now(),
                    isDone: false,
                  );
                  todoBox.add(newTodo);
                  Navigator.pop(context);
                }
              },
              child: const Text("Add" ,style: TextStyle(fontSize: 20),),
            ),
          ),
        ],
        ),
      ),
    );
  }
}