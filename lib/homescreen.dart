import 'package:flutter/material.dart';

class home_screen extends StatefulWidget {
  const home_screen({super.key});

  @override
  State<home_screen> createState() => _homescreenState();
}

class _homescreenState extends State<home_screen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: CustomScrollView(
        slivers: [
          SliverAppBar(
            elevation: 0,
            pinned: false,
            centerTitle: false,
            flexibleSpace: const FlexibleSpaceBar(
                background: Color.fromRGBO(103, 202, 202, 100),
            ),
          ),
        ],
      ),
      );
  }
}