

import 'package:hive/hive.dart';
import 'package:hive_flutter/hive_flutter.dart';
part 'Todo.g.dart';

@HiveType(typeId: 1)
class Todo{
  @HiveField(0)
  final String title;
  @HiveField(2)
  final String description; 
  @HiveField(3)
  final DateTime date;
  @HiveField(4)
  final DateTime time;
  @HiveField(5)
  final bool isDone;
  
  Todo({
    required this.title,
    required this.description,
    required this.date,
    required this.time,
    required this.isDone,
  });


}