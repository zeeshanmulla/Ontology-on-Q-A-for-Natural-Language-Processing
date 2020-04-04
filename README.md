# Ontology-on-Q-A-for-Natural-Language-Processing
Question answering (QA) system aims at retrieving precise information from a large collection of documents against a query. The proposed architecture defines four basic modules suitable for enhancing current QA capabilities with the ability of processing complex questions. The first module was the question processing, which analyses and classifies the question and also reformulates the user query. The second module allows the process of retrieving the relevant ontological relations from the given question. The next module processes the retrieved words from question. Natural language processing techniques are used for processing the question and documents and also for answer extraction. Ontology and domain knowledge are used for reformulating queries and identifying the relations. 


**Performance Evaluation and Result Evaluation**

The interface:

![1](https://user-images.githubusercontent.com/29397302/78455036-9fc90480-76b9-11ea-9040-76918ac4a481.jpg)

The above figure represents the system UI as presented to the user. The drop down menu at the top left corner allows the user to select a particular subject of the domain from which he/she prefers to obtain information from. The main interface has 4 function buttons, they are as follows : 
Tokenization : Generates tokens for the user entered Query.
Remove Stop Words : Removes stop words from the tokens. The stop words are removed by compaing each and every token with the stop word dictionary.
Stemming : Removes the suffixes like ‘ing’,’ment’ , ‘ ‘s’ , ‘es’ , ‘s’ etc from the words.
Get Answer :  Displays the answer for the user Query and generates an Ontology for the same.

**SAMPLE INPUT **

A sample Query is fired at the system. The Query is : “What is harshal’s mother’s name ? “.
The Query precessing and the answer is obtained according to the following steps :

![image](https://user-images.githubusercontent.com/29397302/78455141-31d10d00-76ba-11ea-9e38-72731b0dac9c.png)

In the above figure, the user wants to know the name of harshal’s mother and asks the system about it.

**Tokenization **

![image](https://user-images.githubusercontent.com/29397302/78455172-5200cc00-76ba-11ea-8261-c7f2e9fc0367.png)

Tokenization : The tokens for the query are generated. The tokens are as follows: 
What    is    harshal’s    mother’s     mother    name    ?

**Remove stop words **

![image](https://user-images.githubusercontent.com/29397302/78455192-6f359a80-76ba-11ea-8d4f-a134b47c4937.png)

This step removes the stop words ‘what’ ‘is’ ‘?’ from the tokens obtained.

**Stemming **

![image](https://user-images.githubusercontent.com/29397302/78455237-b754bd00-76ba-11ea-949a-4a4eb10a04ba.png)

Suffixes like ‘ ‘s’’ is removed.

**Get Answer**

![image](https://user-images.githubusercontent.com/29397302/78455253-c9cef680-76ba-11ea-8027-98730c497333.png)

The answer is presented to the user and the ontology is generated as shown below.

![image](https://user-images.githubusercontent.com/29397302/78455269-ee2ad300-76ba-11ea-8f07-7986c27eeddb.png)

A few more Ontologies that can be obtained from the system is as follows:
User Query : What is harshal’s brother’s hobby and where does he stay?

![image](https://user-images.githubusercontent.com/29397302/78455335-58437800-76bb-11ea-834b-a720790135cb.png)

Graph showing harshal’s brother’s hobby and the place where he stays.

User Query: What is harshal’s father’s name,age and where does he stay?

![image](https://user-images.githubusercontent.com/29397302/78455346-698c8480-76bb-11ea-9d9d-2ac82b6a8719.png)

Graph showing harshal’s father’s information.

 
Question Answering is the process of extracting answers to natural language questions. A QA system takes questions in natural language as input, searches for answers in a set of documents, and extracts and frames concise answers. QA systems provide answers to the natural language questions by considering an archive of documents. Instead of providing the precise answers, in most of the current information retrieval systems the users have to select the required information from a ranked list of documents. Information Extraction (IE) is the name given to any process which selectively structures and combines data which is found, explicitly stated or implied, in one or more texts. After finding the significant documents, the IR system submits those to the user. The scope of the QA has been constrained to domain specific systems, due to the complications in natural language processing (NLP) techniques. Current search engines can return ranked lists of documents, but not the answers to the user queries.
Novice users may lack adequate knowledge in the domain of search, so the query framed by them may not meet the information needs. Moreover, the query that the users often codify captures many documents that are irrelevant, and also fails to find the knowledge or relationships that are hidden in the articles. To overcome this drawback, many systems provide various facilities such as relevance feed-back, with which searchers can find out the documents that are of interest to them. With these questions about the current techniques in mind, a new querying approach can be developed based on domain specific ontologies and some NLP techniques for better results. Also syntactic analysis based on rules and semantic role labeling can be applied to improve both query construction and answer extraction. With this information we will be able to analyze and extract structure and meaning from both questions and candidate sentences, which helps us to identify more relevant and precise answers in a long list of candidate sentences.
In our ontological QA system, both questions and domain knowledge are represented by the same ontological language. It is foreseen to develop the QA system in two steps. First a prototypical implementation is planned to answer questions related to the current “state-of-affairs” of the site to which the question is posed. In a second step, given a “federation” of sites within the same domain, we will investigate whether and how an ontological approach could support QA across the sites. Answering a question can then be seen as a collaborative task between ontological nodes belonging to the same QA system. Since each node has its own version of the domain ontology, the task of passing a question from node to node may be reduced to a mapping task between (similar) conceptual representations. To make such an approach feasible, a number of difficult problems must still be solved.

**Natural Processing Language (NLP)**

Natural language processing (NLP) is concerned with the development of computational models of aspects of human language processing. NLP involve natural language understanding, that is, enabling computers to derive meaning from human or natural language input, and others involve natural language generation. It is related to the area of human–computer interaction.
The development of NLP applications is challenging because computers traditionally require humans to “speak” to them in a programming language that is precise, unambiguous and highly structured or, perhaps through a limited number of clearly-enunciated voice commands. Human speech, however, is not always precise -- it is often ambiguous and the linguistic structure can depend on many complex variables, including slang, regional dialects and social context. Current approaches to NLP are based on machine learning a type of artificial intelligence that examines and uses patterns in data to improve a program's own understanding. Most of the research being done on natural language processing revolves around search Common NLP tasks in software programs today include:
• Sentence segmentation, part-of-speech tagging and parsing
• Deep analytics
• Named entity extraction.
• Co-reference resolution.

**What is Ontology?**
Ontology enables information from one resource to be mapped accurately at an extremely granular level to information from another source. Multiple instances of a concept in different structured or unstructured data sources can be mapped to a specific ontology concept and, therefore, the data in those original sources can be integrated semantically. The ontology provides the common vocabulary for the data integration – showing the preferred names for a concept, and the synonyms and properties associated with it. This enables forward-looking integration by collecting data using names that are already well understood rather than ones that might not be shared widely throughout the organization. This makes the assimilation of new data easier and quicker, and facilitates communication between groups. Organizing data integration around the ontology provides the middle layer that makes data integration more efficient – reducing the cost, maintenance and risk of the project. Furthermore, because the ontology can be grown over time as new data become available, new links are continually being made and new knowledge assimilated in the ontology.
Ontologies provide a highly dynamic and flexible map of the information contained in the data sources within a domain. Because ontologies enable true semantic integration across the data sources that they represent, it is possible not only to draw wider conclusions from the data but also to look at the data from several distinct perspectives relevant to the specific job being undertaken. The generation of ontologies to represent data from several underlying data sources is a precursor to and an important enabler of semantic data integration. Ontologies make data integration more efficient and more detailed, and reduce the risk associated with the continual redevelopment of project-specific integration strategies. 

1.2 Motivation 
                
With the rapid developments in NLP domain, numerous technologies and tools have been used to facilitate communication, coordination, cooperation, and production activities. An agent-based question answering system is presented in which, assists learning mechanisms. When a learner sends a question, an agent searches a FAQ document and also forwards the question to a selected learner(s). The agent in the system utilizes text mining techniques (word extraction, word weighting, word counting, and vector construction) to autonomously select an answer from FAQ or obtain a response from learners corresponding to the question. The system assists not only in offering answer(s) to the learner, but also provides the opportunities of collaboration and learning to learners by answering the questions of other learners. 


1.3 Objective 
               
Our main goal is to create a question answering system by integrating several technologies such as ontologies, Logic and NLP. Then we had built AQUA where AQUA stands for Automated Question Answering System. AQUA attempts to exploit semantically annotated web pages with the main purpose of answer questions. 
More specifically, this dissertation deals with the following objectives: 
1. Creating Medical Question Answering System using Domain Knowledge.
2. Developing QA tools as a tool to extract Medical knowledge.
3. Predicting Quality of Answer in QA Community.


EXISTING SYSTEM:

           A user dose not chooses when to consult the resources, when to do the research and when to solve the questionnaire so time is waste. Similarly, the tutors can grade the user’s activities in their own time.
Nevertheless, because of their general-purpose approach, it is always less uncommon that obtained result sets provide a burden of useless pages. It is not uncommon that even the most renowned search engines return result sets including many pages that are definitely useless for the user this is mainly due to the fact that the very basic relevance criterions underlying their information retrieval strategies rely on the presence of query keywords within the returned pages.

Disadvantages of the Existing System:
•	Manual learning method
•	No system for revised learning
•	Lacks ubiquity
•	Places students in a passive rather than an active role, which hinders learning.
•	Encourages one-way communication; therefore, the lecturer must make a conscious effort to become aware of student problems and student understanding of content without verbal feedback.
•	Requires a considerable amount of unguided student time outside of the classroom to enable understanding and long-term retention of content. In contrast, interactive methods (discussion, problem-solving sessions) allow the instructor to influence students when they are actively working with the material.
•	Requires the instructor to have or to learn effective writing and speaking skills.


Proposed system
To overcome the problems in extant automatic question answering system, such as inadequate knowledge expression and weakness of indicating the inherent relations among knowledge, a solution with using Ontology to build curriculum domain knowledge base was put forward in this paper. In this paper, the course of "Natural Language Processing" was taken as an example to construct an automatic question answering system based on Ontology. The system extracts keywords by analyzing users’ question and transforms the intention of the question into the query of basic elements in Ontology. Finally, the system extracts the answer from ontology relation using NLP. Meanwhile, the system provides related knowledge to help students study systematically. This paper has achieved an automatic question answering system presented in the course of “Natural Language Processing”. This automatic question answering system supports asking questions in natural language.

Module description:
1.	Data Collection
In this user enter one question from medical field and click on submit after submitting our system get preprocess. 
2.	Stop words removing:
In this phase all data get from document and remove Stop words where disambiguation has to perform.
3.	Stemming process:
In this process of reducing inflected (or sometimes derived) words to their word stem, base or root form—generally a written word form. The stem need not be identical to the morphological root of the word; it is usually sufficient that related words map to the same stem, even if this stem is not in itself a valid root.
4.	POS Tagging
A Part-Of-Speech Tagger (POS Tagger) is step that reads text in paragraph and assigns parts of speech to each word (and other token), such as noun, verb, adjective, etc., although generally computational applications use more fine-grained POS tags like 'noun-plural'.
6. Output
In this module we display final output from ontology words from the derived root words with the test data OWL/RFD dataset and we will get the final best answer of that question.
