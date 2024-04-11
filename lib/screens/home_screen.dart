import 'package:flutter/material.dart';
import 'package:hive/hive.dart';
import 'package:hivedb/modules/Todo.dart';
import 'package:hivedb/screens/add_todo.dart';
import 'package:hive_flutter/hive_flutter.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({super.key});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  Box todoBox = Hive.box("todo");
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Todo App'),
        backgroundColor: Colors.deepPurple,
        titleTextStyle: const TextStyle(
          color: Colors.white,
          fontSize: 20,
          fontWeight: FontWeight.bold,
        ),
      ),
      body: ValueListenableBuilder(valueListenable: todoBox.listenable(),
      builder: (context, Box box,widget){
      if(box.isEmpty){
        return const Center(
          child: Text("No Todo Available"),
        );
      }else{
      return ListView.builder(
        reverse: true,
        shrinkWrap: true,
        itemCount: box.length,
        itemBuilder: (context, index){
          Todo todo = box.getAt(index);
          return ListTile(
            onTap: (){
              
            },
            title: Text(todo.title, style: TextStyle(
              fontSize: 20,
              fontWeight: FontWeight.bold,
              color: todo.isDone? Colors.grey: Colors.black,
              decoration: todo.isDone? TextDecoration.lineThrough: TextDecoration.none,
            ),
            ),
            leading: Checkbox(
              value: todo.isDone,
              onChanged: (value){
               Todo newTodo = Todo(
                title: todo.title,
                description: todo.description,
                date: todo.date,
                time: todo.time,
                isDone: value!,
               );
                box.putAt(index, newTodo);
              },
            ),
            trailing: IconButton(
              icon: Icon(Icons.delete, color: Colors.red,),
              onPressed: (){
                box.deleteAt(index);
                ScaffoldMessenger.of(context).showSnackBar(
                 const SnackBar(
                    content: Text("Todo Deleted"),
                    duration: Duration(seconds: 2),
                  ),
                );
              },
            ),
          );

        },
      );
      }
      },
      ),
    floatingActionButton: FloatingActionButton(
      child: const Icon(Icons.add),
      onPressed: (){
        Navigator.push(context, MaterialPageRoute(builder: (context)=>Addtodo()));
      },
    ),
    );
  }
}