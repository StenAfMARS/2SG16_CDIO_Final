<html>
<body>
<h2>Hello World!</h2>
<script src="WEB-INF/jsPDF.js"></script>
<script src="WEB-INF/download.js"></script>
<script type="javascript">
    var doc = new jsPDF();
    doc.text(20, 20, 'Hello world!');
    download(doc.output(), "test.pdf", "pdf")
</script>
</body>
</html>
