import 'package:flutter/material.dart';

class MyHomePage extends StatefulWidget {
  MyHomePage({Key key, this.title}) : super(key: key);


  final String title;



  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {

  int radioGroup = 0;
  void radioEventHandler(int radioValue){
    setState(() {
      radioGroup = radioValue;
      print(radioGroup);
    });
  }

  @override
  Widget build(BuildContext context) {

    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.teal,
        // Here we take the value from the MyHomePage object that was created by
        // the App.build method, and use it to set our appbar title.
        title: Text(widget.title),
      ),
      body: Container(
        // Center is a layout widget. It takes a single child and positions it
        // in the middle of the parent.
        child: ListView(
          children: <Widget>[
            Container(
              padding: EdgeInsets.only(top: 30),
              child:
              Image.asset("images/person.png", width: 100, height: 100,),
            ),
            Container(
              padding: EdgeInsets.only(top: 25),
              margin: EdgeInsets.only(top: 25),
              child:
              Column(
                children: [
                  Text("Please Make Order", style: TextStyle(fontSize: 18),),
                  Padding(padding: EdgeInsets.only(top: 20)),
                  TextField(
                    style: TextStyle(color: Colors.deepOrange),
                    decoration: InputDecoration(
                      hintText: "Enter Order",
                      labelText: "Choose Your Order",
                      icon: Icon(Icons.shopping_cart,color: Colors.deepOrange,)
                    ),
                    controller: null,
                  ),
                  Padding(padding: EdgeInsets.only(top: 20)),
                  Column(
                    children: [
                      RadioListTile(
                        value: 0,
                        title: Text("Macdonalds"),
                        subtitle: Text("Please Choose Macdonalds"),
                        groupValue: radioGroup,
                        onChanged: radioEventHandler,
                        activeColor: Colors.indigo,
                      ),
                      RadioListTile(
                        value: 1,
                        title: Text("Burger King"),
                        subtitle: Text("Please Choose Burger King"),
                        groupValue: radioGroup,
                        onChanged: radioEventHandler,
                        activeColor: Colors.indigo,
                      ),
                    ],
                  )
                ],
              )
            ),
          ],
        ),
      ),
    );
  }
}
