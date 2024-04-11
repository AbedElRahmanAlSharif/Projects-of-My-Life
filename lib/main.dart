
import 'package:flutter/material.dart';
import 'package:hivedb/screens/home_screen.dart';
import 'package:hivedb/modules/Todo.dart';
import 'package:hive_flutter/adapters.dart';

void main() async{
  // WidgetsFlutterBinding.ensureInitialized();
  // Directory directory = await getApplicationDocumentsDirectory();
  Hive.initFlutter();
  //? Registering the adapter
  Hive.registerAdapter(TodoAdapter());
  //! Opening the box
  await Hive.openBox('todo');
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Todo List App',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        useMaterial3: true,
      ),
      home: const HomeScreen(),
    );
  }
}

