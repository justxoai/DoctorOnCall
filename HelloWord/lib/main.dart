import 'package:flutter/material.dart';
import 'package:helloword/pages/home.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      debugShowCheckedModeBanner: false, // Turn off the debug banner on the right top conner
      home: HomePage()
    );
  }
}
