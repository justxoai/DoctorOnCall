import 'package:flutter/material.dart';
import 'package:flutter_svg/flutter_svg.dart';

class HomePage extends StatelessWidget {
  const HomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: appBar(),
      body: Column(
        children: [
          TextField(
            decoration: InputDecoration(
              filled: true,
              fillColor: Color(0xFFFFFFFF)
            ),
          )
        ],
      ),
    );
  }

  AppBar appBar(){
    return AppBar(
      title: Text(
          "Hello Word from Dart",
          style: TextStyle(
              color: Color(0xFFFFFFFF),
              fontSize: 25,
              fontWeight: FontWeight.bold)),
      centerTitle: true,
      backgroundColor: Color(0xFFE34C2D),
      leading: Container(
        margin: EdgeInsets.all(10),
        alignment: Alignment.center,
        child: SvgPicture.asset(
          "assets/icon/backward.svg",
          width: 15,
          height: 15,),
        decoration: BoxDecoration(
            color: Color(0xFF00FF00),
            borderRadius: BorderRadius.circular(50)
        ),
      ),
      actions: [
        Container(
          margin: EdgeInsets.all(10),
          alignment: Alignment.center,
          width: 40,
          child: SvgPicture.asset(
            "assets/icon/setting.svg",
            width: 25,
            height: 25,),
          decoration: BoxDecoration(
              color: Color(0xFF00FF00),
              borderRadius: BorderRadius.circular(50)
          ),
        )
      ],
    );
  }
}
