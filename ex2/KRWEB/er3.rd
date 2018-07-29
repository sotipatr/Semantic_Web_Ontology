<rdf:RDF
    xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
    xmlns:rdfs="http://www.w3.org/2000/01/rdf-schema#"
    xmlns:uni="http://www.mydomain.org/uni-ns/" > 
  <rdf:Description rdf:about="http://www.mydomain.org/uni-ns/Prof4">
    <uni:teaches rdf:resource="http://www.mydomain.org/uni-ns/Less5"/>
    <uni:member_of rdf:resource="http://www.mydomain.org/uni-ns/Dep1"/>
    <uni:has_age>39</uni:has_age>
    <uni:has_phone>6904321678</uni:has_phone>
    <uni:has_name>Ioannis Hatziligeroudis</uni:has_name>
    <rdf:type rdf:resource="http://www.mydomain.org/uni-ns/Professor"/>
  </rdf:Description>
  <rdf:Description rdf:about="http://www.mydomain.org/uni-ns/Prof6">
    <uni:teaches rdf:resource="http://www.mydomain.org/uni-ns/Less2"/>
    <uni:member_of rdf:resource="http://www.mydomain.org/uni-ns/Dep3"/>
    <uni:has_age>42</uni:has_age>
    <uni:has_phone>6943213456</uni:has_phone>
    <uni:has_name>Ioanna Dimitriou</uni:has_name>
    <rdf:type rdf:resource="http://www.mydomain.org/uni-ns/Professor"/>
  </rdf:Description>
  <rdf:Description rdf:about="http://www.mydomain.org/uni-ns/Dep1">
    <uni:dep_city>Patras</uni:dep_city>
    <uni:dep_name>CEID</uni:dep_name>
    <rdf:type rdf:resource="http://www.mydomain.org/uni-ns/Department"/>
  </rdf:Description>
  <rdf:Description rdf:about="http://www.mydomain.org/uni-ns/Prof2">
    <uni:teaches rdf:resource="http://www.mydomain.org/uni-ns/Less1"/>
    <uni:member_of rdf:resource="http://www.mydomain.org/uni-ns/Dep3"/>
    <uni:has_age>45</uni:has_age>
    <uni:has_phone>6931789406</uni:has_phone>
    <uni:has_name>Maria Stathopoulou</uni:has_name>
    <rdf:type rdf:resource="http://www.mydomain.org/uni-ns/Professor"/>
  </rdf:Description>
  <rdf:Description rdf:about="http://www.mydomain.org/uni-ns/Student">
    <rdfs:subClassOf rdf:resource="http://www.mydomain.org/uni-ns/Person"/>
    <rdf:type rdf:resource="http://www.w3.org/2000/01/rdf-schema#Class"/>
  </rdf:Description>
  <rdf:Description rdf:about="http://www.mydomain.org/uni-ns/Stud12">
    <uni:member_of rdf:resource="http://www.mydomain.org/uni-ns/Dep3"/>
    <uni:has_age>20</uni:has_age>
    <uni:has_phone>6956432109</uni:has_phone>
    <uni:has_name>Eugenia Louka</uni:has_name>
    <rdf:type rdf:resource="http://www.mydomain.org/uni-ns/Student"/>
  </rdf:Description>
  <rdf:Description rdf:about="http://www.mydomain.org/uni-ns/has_name">
    <rdfs:range rdf:resource="http://www.w3.org/2000/01/rdf-schema#Literal"/>
    <rdfs:domain rdf:resource="http://www.mydomain.org/uni-ns/Person"/>
    <rdf:type rdf:resource="http://www.w3.org/1999/02/22-rdf-syntax-ns#Property"/>
  </rdf:Description>
  <rdf:Description rdf:about="http://www.mydomain.org/uni-ns/Stud9">
    <uni:member_of rdf:resource="http://www.mydomain.org/uni-ns/Dep2"/>
    <uni:has_age>19</uni:has_age>
    <uni:has_phone>6909786345</uni:has_phone>
    <uni:has_name>Sofia Athanasopoulou</uni:has_name>
    <rdf:type rdf:resource="http://www.mydomain.org/uni-ns/Student"/>
  </rdf:Description>
  <rdf:Description rdf:about="http://www.mydomain.org/uni-ns/Stud10">
    <uni:member_of rdf:resource="http://www.mydomain.org/uni-ns/Dep3"/>
    <uni:has_age>25</uni:has_age>
    <uni:has_phone>6965478902</uni:has_phone>
    <uni:has_name>Ksanthipi Foka</uni:has_name>
    <rdf:type rdf:resource="http://www.mydomain.org/uni-ns/Student"/>
  </rdf:Description>
  <rdf:Description rdf:about="http://www.mydomain.org/uni-ns/Stud7">
    <uni:member_of rdf:resource="http://www.mydomain.org/uni-ns/Dep2"/>
    <uni:has_age>21</uni:has_age>
    <uni:has_phone>6954367890</uni:has_phone>
    <uni:has_name>Nikolaos Boukolou</uni:has_name>
    <rdf:type rdf:resource="http://www.mydomain.org/uni-ns/Student"/>
  </rdf:Description>
  <rdf:Description rdf:about="http://www.mydomain.org/uni-ns/Stud5">
    <uni:member_of rdf:resource="http://www.mydomain.org/uni-ns/Dep1"/>
    <uni:has_age>19</uni:has_age>
    <uni:has_phone>6978654567</uni:has_phone>
    <uni:has_name>Konstantina Dimou</uni:has_name>
    <rdf:type rdf:resource="http://www.mydomain.org/uni-ns/Student"/>
  </rdf:Description>
  <rdf:Description rdf:about="http://www.mydomain.org/uni-ns/Less4">
    <uni:taught_by rdf:resource="http://www.mydomain.org/uni-ns/Prof3"/>
    <uni:les_name>Linear Algebra</uni:les_name>
  </rdf:Description>
  <rdf:Description rdf:about="http://www.mydomain.org/uni-ns/taught_by">
    <rdfs:range rdf:resource="http://www.mydomain.org/uni-ns/Professor"/>
    <rdfs:domain rdf:resource="http://www.mydomain.org/uni-ns/Lesson"/>
    <rdf:type rdf:resource="http://www.w3.org/1999/02/22-rdf-syntax-ns#Property"/>
  </rdf:Description>
  <rdf:Description rdf:about="http://www.mydomain.org/uni-ns/Person">
    <rdf:type rdf:resource="http://www.w3.org/2000/01/rdf-schema#Class"/>
  </rdf:Description>
  <rdf:Description rdf:about="http://www.mydomain.org/uni-ns/Stud3">
    <uni:member_of rdf:resource="http://www.mydomain.org/uni-ns/Dep1"/>
    <uni:has_age>20</uni:has_age>
    <uni:has_phone>6990865432</uni:has_phone>
    <uni:has_name>Dimitris Theodorou</uni:has_name>
    <rdf:type rdf:resource="http://www.mydomain.org/uni-ns/Student"/>
  </rdf:Description>
  <rdf:Description rdf:about="http://www.mydomain.org/uni-ns/Less6">
    <uni:taught_by rdf:resource="http://www.mydomain.org/uni-ns/Prof5"/>
    <uni:les_name>Power Systems</uni:les_name>
  </rdf:Description>
  <rdf:Description rdf:about="http://www.mydomain.org/uni-ns/Stud1">
    <uni:member_of rdf:resource="http://www.mydomain.org/uni-ns/Dep1"/>
    <uni:has_age>22</uni:has_age>
    <uni:has_phone>6946732190</uni:has_phone>
    <uni:has_name>Sotiria Patroni</uni:has_name>
    <rdf:type rdf:resource="http://www.mydomain.org/uni-ns/Student"/>
  </rdf:Description>
  <rdf:Description rdf:about="http://www.mydomain.org/uni-ns/Dep3">
    <uni:dep_city>Athens</uni:dep_city>
    <uni:dep_name>Philosophy</uni:dep_name>
    <rdf:type rdf:resource="http://www.mydomain.org/uni-ns/Department"/>
  </rdf:Description>
  <rdf:Description rdf:about="http://www.mydomain.org/uni-ns/Dep12">
    <uni:dep_city>Athens</uni:dep_city>
    <uni:dep_name>Mathematic</uni:dep_name>
    <rdf:type rdf:resource="http://www.mydomain.org/uni-ns/Department"/>
  </rdf:Description>
  <rdf:Description rdf:about="http://www.mydomain.org/uni-ns/Less2">
    <uni:taught_by rdf:resource="http://www.mydomain.org/uni-ns/Prof6"/>
    <uni:les_name>Introduction to Philosophy</uni:les_name>
  </rdf:Description>
  <rdf:Description rdf:about="http://www.mydomain.org/uni-ns/Prof3">
    <uni:teaches rdf:resource="http://www.mydomain.org/uni-ns/Less4"/>
    <uni:member_of rdf:resource="http://www.mydomain.org/uni-ns/Dep1"/>
    <uni:has_age>50</uni:has_age>
    <uni:has_phone>6976345698</uni:has_phone>
    <uni:has_name>Eustratios Gallopoulos</uni:has_name>
    <rdf:type rdf:resource="http://www.mydomain.org/uni-ns/Professor"/>
  </rdf:Description>
  <rdf:Description rdf:about="http://www.mydomain.org/uni-ns/Dep2">
    <uni:dep_city>Patras</uni:dep_city>
    <uni:dep_name>ECE</uni:dep_name>
    <rdf:type rdf:resource="http://www.mydomain.org/uni-ns/Department"/>
  </rdf:Description>
  <rdf:Description rdf:about="http://www.mydomain.org/uni-ns/Prof5">
    <uni:teaches rdf:resource="http://www.mydomain.org/uni-ns/Less6"/>
    <uni:member_of rdf:resource="http://www.mydomain.org/uni-ns/Dep2"/>
    <uni:has_age>44</uni:has_age>
    <uni:has_phone>6990876542</uni:has_phone>
    <uni:has_name>Nikolaos Papanikolaou</uni:has_name>
    <rdf:type rdf:resource="http://www.mydomain.org/uni-ns/Professor"/>
  </rdf:Description>
  <rdf:Description rdf:about="http://www.mydomain.org/uni-ns/Lesson">
    <rdf:type rdf:resource="http://www.w3.org/2000/01/rdf-schema#Class"/>
  </rdf:Description>
  <rdf:Description rdf:about="http://www.mydomain.org/uni-ns/dep_city">
    <rdfs:range rdf:resource="http://www.w3.org/2000/01/rdf-schema#Literal"/>
    <rdfs:domain rdf:resource="http://www.mydomain.org/uni-ns/Department"/>
    <rdf:type rdf:resource="http://www.w3.org/1999/02/22-rdf-syntax-ns#Property"/>
  </rdf:Description>
  <rdf:Description rdf:about="http://www.mydomain.org/uni-ns/Prof1">
    <uni:teaches rdf:resource="http://www.mydomain.org/uni-ns/Less3"/>
    <uni:member_of rdf:resource="http://www.mydomain.org/uni-ns/Dep1"/>
    <uni:has_age>34</uni:has_age>
    <uni:has_phone>6986548907</uni:has_phone>
    <uni:has_name>Georgios Papadopoulos</uni:has_name>
    <rdf:type rdf:resource="http://www.mydomain.org/uni-ns/Professor"/>
  </rdf:Description>
  <rdf:Description rdf:about="http://www.mydomain.org/uni-ns/les_name">
    <rdfs:range rdf:resource="http://www.w3.org/2000/01/rdf-schema#Literal"/>
    <rdfs:domain rdf:resource="http://www.mydomain.org/uni-ns/Lesson"/>
    <rdf:type rdf:resource="http://www.w3.org/1999/02/22-rdf-syntax-ns#Property"/>
  </rdf:Description>
  <rdf:Description rdf:about="http://www.mydomain.org/uni-ns/dep_name">
    <rdfs:range rdf:resource="http://www.mydomain.org/uni-ns/Literal"/>
    <rdfs:domain rdf:resource="http://www.mydomain.org/uni-ns/Department"/>
    <rdf:type rdf:resource="http://www.w3.org/1999/02/22-rdf-syntax-ns#Property"/>
  </rdf:Description>
  <rdf:Description rdf:about="http://www.mydomain.org/uni-ns/Stud11">
    <uni:member_of rdf:resource="http://www.mydomain.org/uni-ns/Dep3"/>
    <uni:has_age>23</uni:has_age>
    <uni:has_phone>6909873212</uni:has_phone>
    <uni:has_name>Mattheos Papatheodorou</uni:has_name>
    <rdf:type rdf:resource="http://www.mydomain.org/uni-ns/Student"/>
  </rdf:Description>
  <rdf:Description rdf:about="http://www.mydomain.org/uni-ns/Stud8">
    <uni:member_of rdf:resource="http://www.mydomain.org/uni-ns/Dep2"/>
    <uni:has_age>18</uni:has_age>
    <uni:has_phone>6921345678</uni:has_phone>
    <uni:has_name>Iakobos Athanasiou</uni:has_name>
    <rdf:type rdf:resource="http://www.mydomain.org/uni-ns/Student"/>
  </rdf:Description>
  <rdf:Description rdf:about="http://www.mydomain.org/uni-ns/Department">
    <rdf:type rdf:resource="http://www.w3.org/2000/01/rdf-schema#Class"/>
  </rdf:Description>
  <rdf:Description rdf:about="http://www.mydomain.org/uni-ns/member_of">
    <rdfs:range rdf:resource="http://www.mydomain.org/uni-ns/Department"/>
    <rdfs:domain rdf:resource="http://www.mydomain.org/uni-ns/Person"/>
    <rdf:type rdf:resource="http://www.w3.org/1999/02/22-rdf-syntax-ns#Property"/>
  </rdf:Description>
  <rdf:Description rdf:about="http://www.mydomain.org/uni-ns/Stud6">
    <uni:member_of rdf:resource="http://www.mydomain.org/uni-ns/Dep2"/>
    <uni:has_age>21</uni:has_age>
    <uni:has_phone>6998056432</uni:has_phone>
    <uni:has_name>Konstantinos Iakobou</uni:has_name>
    <rdf:type rdf:resource="http://www.mydomain.org/uni-ns/Student"/>
  </rdf:Description>
  <rdf:Description rdf:about="http://www.mydomain.org/uni-ns/Stud4">
    <uni:member_of rdf:resource="http://www.mydomain.org/uni-ns/Dep1"/>
    <uni:has_age>24</uni:has_age>
    <uni:has_phone>6945321809</uni:has_phone>
    <uni:has_name>Basileios Georgiou</uni:has_name>
    <rdf:type rdf:resource="http://www.mydomain.org/uni-ns/Student"/>
  </rdf:Description>
  <rdf:Description rdf:about="http://www.mydomain.org/uni-ns/Less3">
    <uni:taught_by rdf:resource="http://www.mydomain.org/uni-ns/Prof1"/>
    <uni:les_name>Computer Architecture</uni:les_name>
  </rdf:Description>
  <rdf:Description rdf:about="http://www.mydomain.org/uni-ns/has_age">
    <rdfs:range rdf:resource="http://www.w3.org/2000/01/rdf-schema#integer"/>
    <rdfs:domain rdf:resource="http://www.mydomain.org/uni-ns/Person"/>
    <rdf:type rdf:resource="http://www.w3.org/1999/02/22-rdf-syntax-ns#Property"/>
  </rdf:Description>
  <rdf:Description rdf:about="http://www.mydomain.org/uni-ns/Stud2">
    <uni:member_of rdf:resource="http://www.mydomain.org/uni-ns/Dep1"/>
    <uni:has_age>23</uni:has_age>
    <uni:has_phone>6956734217</uni:has_phone>
    <uni:has_name>Ioanna Papa</uni:has_name>
    <rdf:type rdf:resource="http://www.mydomain.org/uni-ns/Student"/>
  </rdf:Description>
  <rdf:Description rdf:about="http://www.mydomain.org/uni-ns/Less5">
    <uni:taught_by rdf:resource="http://www.mydomain.org/uni-ns/Prof4"/>
    <uni:les_name>K.R.W.E.B.</uni:les_name>
  </rdf:Description>
  <rdf:Description rdf:about="http://www.mydomain.org/uni-ns/teaches">
    <rdfs:range rdf:resource="http://www.mydomain.org/uni-ns/Lesson"/>
    <rdfs:domain rdf:resource="http://www.mydomain.org/uni-ns/Professor"/>
    <rdf:type rdf:resource="http://www.w3.org/1999/02/22-rdf-syntax-ns#Property"/>
  </rdf:Description>
  <rdf:Description rdf:about="http://www.mydomain.org/uni-ns/Less1">
    <uni:taught_by rdf:resource="http://www.mydomain.org/uni-ns/Prof2"/>
    <uni:les_name>Literature</uni:les_name>
  </rdf:Description>
  <rdf:Description rdf:about="http://www.mydomain.org/uni-ns/has_phone">
    <rdfs:range rdf:resource="http://www.w3.org/2000/01/rdf-schema#Literal"/>
    <rdfs:domain rdf:resource="http://www.mydomain.org/uni-ns/Person"/>
    <rdf:type rdf:resource="http://www.w3.org/1999/02/22-rdf-syntax-ns#Property"/>
  </rdf:Description>
  <rdf:Description rdf:about="http://www.mydomain.org/uni-ns/Professor">
    <rdfs:subClassOf rdf:resource="http://www.mydomain.org/uni-ns/Person"/>
    <rdf:type rdf:resource="http://www.w3.org/2000/01/rdf-schema#Class"/>
  </rdf:Description>
</rdf:RDF>
