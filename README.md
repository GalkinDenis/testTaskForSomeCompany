Android приложение (com.android.application) и библиотека (com.android.library).

В папке LIBRARY_AAR находится выходной файл библиотеки используемой в приложении, в формате aar.

Библиотека соответствует следующим критериям:
• По вызову метода из публичного класса библиотеки, показывается новое окно Activity с текстом, указанным в качестве параметра к вызываемому методу.
• В основное приложение отправляется информация об открытии и закрытии окна, из предыдущего пункта.
• По вызову метода из публичного класса вызывается диалог для выбора изображения

Приложение соответствует следующим критериям:
• Вызов методов из библиотеки
• Обработка информации об открытии и закрытии окна библиотеки
• Показ изображения, выбранного из диалога.
