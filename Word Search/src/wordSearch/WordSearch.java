package wordSearch;
//ac 不记得什么时候了2015-5-4
public class WordSearch {

	/**
	 * @param args
	 */
    public static boolean exist(char[][] board, String word) {
    	int len_row=board.length,len_col;
//    	boolean[][] save=new boolean[len_row][board[0].length];
    //用boolean存储好像时间少点
    	
    	boolean flag=false;
    	char[][] save=new char[len_row][];
    	for(int i=0;i<len_row;i++){
    		len_col=board[i].length;
    		for(int j=0;j<len_col;j++){
    			flag=flag||judge(i,j,board,word,save);	
    			if(flag){
    				return true;
    			}
    		}
    	}
    	return false;
    }
    public static boolean judge(int i,int j,char[][] s,String str,char[][] save){
    	boolean flag=false;
    	if(s[i][j]==str.charAt(0)){
    		char ch=s[i][j];
    		if(str.length()==1){
    			return true;
    		}
    		s[i][j]='0';
    		if(i!=0){
    			flag=flag||judge(i-1,j,s,str.substring(1, str.length()),save);
    			
    		}
    		if(j!=0){
    			flag=flag||judge(i,j-1,s,str.substring(1, str.length()),save);
    			
    		}
    		if(i!=s.length-1){
    			flag=flag||judge(i+1,j,s,str.substring(1, str.length()),save);
    		}
    		if(j!=s[i].length-1){
    			flag=flag||judge(i,j+1,s,str.substring(1,str.length()),save);
    		}
    		s[i][j]=ch;
    	}
    	return flag;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] s=new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
//		String[]  str= new String[]{"elxllvxegzmvgnhrypvagxrgwktiqnyuavfnsfsbgewnrferubrcykjwveenrfhtamhvtzwafspzxvqtwkxwwgttkzgdenzhcgcvhyxosonrjgmhsjeo","qxkcyqidehkipofwofmgtazfilocwuqotatstbvzkhhzvmxjrjrnlsutdixbdoqwqjolklkwstvpgsyzdropjikoriquygsqphcbuoxniucoodpruegg","mrudzkzxsupjbrmxgjkofpetutnoztwmmrrndtmwncfqtsnbdaplrvglptbqpycdpwrspdqehyudsjevjwictpnkkpbznfdebwysbpwjnsmfcscnqnqk","cdumuvojbtnepmxqdvbsopzskdfaqxkudhhxexhfqwkfkjxnezhuqgmamsbcrnxuwgsbdbgtxsaidxxiyfcplrpxlqccgzxchrdksmfpgfxkexudcysp","phnaarfisckztqllcqckxcubzqebpyqgifjkwosqqeplucyysajreftfwzgnazvkgeufsovisnvpptnkwybagwgeyotypokwteblsywmlrbbnrljrmlx","ltbjiujxjtvczwprvlfifhjsaubrjmpugsfqnopyjlcijrbgfgpkpacpvfhgtwczohrdxhbgudqfxroczdopdqeavliojkqarjdqshwomoujfinhnbws","tatoobfxmxzfidwbkupwjlgqtvxgxvzqyuhmxollnltvqpyalowwbepvcmdzkeriaauyohjducbktzkhpjdrpsorhrstykbykxwbeigzmhlihwpwhupw","pdoyxirvsuvfrsivcowqwiydgpbnmrlbwbbtkuqcomjfgrckgbaejzjrqkgcdrfctgxfcojqctvkkausbuymvhdmsjqxcwzxezchnmzrfxbrxvmapkmn","srbmcrleplcukgdzscszbtraofafpmujdvxfnjmcwoygubhpgzojuhkkmkrexmnchlkuuwzqmxyibhxhioqcvcmindmmrbozoyvkwuciscrvlqcteuxa","zlkmryyibmhqndcjzfutjnovdsokpomozyaqwyzxmipbnslnxhgguxbzpslegxsfxuytuztjhikvaxkzesgypjahdllllgticrexqxgzfqwiqghubpvq","bxxeilsvtleveksuhatotswjygfzvasyxrficxdvijtmtniaodrhvnswtxvrappxhuhjtlhduarqnzsdfjmcxeyscwlcldbszjetwnwspoiepbiukuzj","zxedtrfhuiburhpnulilbqqttypgsoptmvwhnbqhmuddbstygbjjtzcnzstsiknwgkgvnwczqgfuyysgbdqwfslemgyvrmtzwzujwyjoeqifoclrgdnl","ybrkhqhycbzyatjysspyizfycrrkwhxuiofpeoogrpeujosdijbtjhtlalxwsutciarpohvgxcaisulcgovpvrcxezwyvpafprufzqlysngmkroqfkfd","djchkyhfphkeafkbxxzrnfdxyrngdulgfnppowufdgkgnwhkvhbiogfpyuxdqkkvzbknygtdnfjadtnaaojqvqhvleydokzomldmsyrhfbhkuulwluoi","mwfzcddtoejcpmojnfqsiafewqchmtrypwytcdmqhxuwmkizrytcaygxqlgceabvwboyedqnamlowtnoujqujytajacnafkyizxoepbgcnvygkoatgxf","fqfqsjgsrqtzrsoxhpgjcbklnaljhkoobvetemovfjxwblwiccuffgssgddnqrbrmimtwcobllamywvbargfxyzdddttwwmjgbcddsgpegbeeyfernlo","nlutqnomlbxsczvhubwakaeoakvsxgiltcejrswdvtxzvshpvdrhfvygftafbisvnyeeqcjoygntawkycbfhwdpeyplaadvnbbttgdhelxzmtjkxmrfk","xwovozvocsdfwwzcbigphfbbqnacgfmdedbsewgjrjonhprlyzafediwsjyyqmeurfmwdufufvjnlcalbaqhfbdxkdxaqbxjgjfkgmglisavuagwcydh","zjglmeoeflomwtycigosyqnvrvttvydvhjgupwyvhmjgijiqpykqpzliugdpegmmsvihriezvnhfwpxoqhefgrpcxstbzgptbxaugfvduckrujhkqlry","cgcbyvczdusgttbbaweubqnvzufrfypjetkcrpcujwbcpeepakmddzycufubdlnhhzmyoqszmveezkvcwhfzheedjygnltwstiqjallngptizokxyrxh","vbkhbswomujhfbqfmduvsndtenrceojcrvlsnjizdriitbofekcxafseujgbzrdsmqmzzvbcmjlfkbnpnponvgrrszsrqxkcnwcmtdrgoenbfaquqgin","obegbxatumwkkawefpmvtzwaamvsudfjglrhirbffzpqbnwididyhazhowbjbguhslrcfujmtaewoaetkhtshsbwqdhrldzfqqixktkfuodkrhfboyvy","tzwjcfdpicvyufwgyinsyqcpxjtnioldnjmropjwtexnjvvjdicbygtxsmlacydsirlyjuxcausjrnvuyzxyhqwzehbhhebrymqhhnljjdvatqwtptrw","kpyqyzzggaxenpnwcyfneanzsjshdlgpbefzdhfjhfpuucszbamfcagvjycojkfmonmuurfbyvytxssysefvglqslugxfmjtbvpvpvypqwinpcohjtep","huhuporucbpfyfapayfsxpfostvbpcqywysnomjspbxnizfkxmcwbhktdiwukpuinmwdahxpiufqtkaswepxmbtrjrntghettcywjvlurqmkapfytwyh","xtyhklcruimqklmuixoaoamqprrlppsnitwsgalbjyrtldntadvqgijxbairpbgzwctccfdndwhozwjcafuipdfqdojurptptpryuxlztspvraztftbw","xipawyxpqqgjhyhbxvcsprpguozbicyhlpjjngbfzhrghakgvmzlgotafvbpxbwiqfugovlneetmfdscstnyijapebebdamthibxdnkhrgvylobdhqdr","zdgdhmhmmvfwdhtiwgpponozbrfkhkehommxzvjnqojvxfdvnvnbibclujxbubkiqzhpuqcngoievobijolrrnelxbptfzdvykkvaoigesmzgojpcwiw","kohjqwcvyfqwpctrqbxxukwcyiscecaqrizjgdgekydbawssaqpwcoycwseavftopuxvydckbhmddgxfypbadacbsjdpqwdhrccrhgbknpntynywcczf","ediymloeitlbwqsfwvqmlfhlshhujibnmjmavcffvsitiazhxptkuavnhfjtnlizuucpyhwuzenkgoredkoamkpvpyoejxeetgvspsoqydafsrjxdxxr","jmnandfwclcytyskqgaqldvdwebaeatppiqcoxaqidqdbintqnjcqfhnliprlijatbehyezihqlkaydtnpxgwevjpmdawmcppgwpmyxwokgqkmjzdghz","nckcqnenbgcqobfczeypohhavtcabjbomlsczwraewtszyxadxptgywdrydthehvqaaryrtdnmxoluoqsflaejevjhqroyoeaoxaiqdxdbmqxagrgtsm","fyhofyfvywbamyaupguujgkgisaqlscsqmhxmovmkwmxvotmungdvsmekmwxgzqylxvxlsjwpxvmnoyiegnzybfinchtdxroupnihygyvbkirksxqizq","jeaxiislfmbcdqkkoqjltvwkgqkyyjrkprjybbljpnlsfxfupqhildutweuwplgfepdgtqrkdedjbifsymalswfqdbmsmtxskcaftrqyvtjydoqddsox","pvnuwzmkumdhqfmjxcisvrtaijdneukvrxpqydavrfcilorktbeqvxrdjwqnqciibxyzcawuiacvrvfkxjashtvsqnfgpnqqmqrorokbqmwhibrhmuzv","nwndlumahesvvjmozwpqlnzvqrecndaabngmiuoryiptrbhtzylmlkjbdngqsgtttbhdvxxvfmpzpysozfdkrmovcunuciqxjzbgxaeemvdbtxruewhw","lvtnrgjtrzqcztjytpehkikfhcamahilcbyvjkoajgdkcokvfpdpznugrusubcffdgcpqqpbzuobkyypnbgmrbvkvngzqogvujkmbcpaydblcacrdjgw","kbjhqpiidpezyqnzudctgfgkhientkjfnupdmxorostmkgoflsasxgehqiumufrhainogbfuvyjfhzksrkmqsrxjztxuzodbxqpftwboxmuelgyetlxl","cwwdqtzpkfsjxjorfrfeebkrkjwduvqyrpdhkdyuiqffzvyhnglrhwitfgwbbpzteccohblrtqzvoxcbdpsnlcgsjftmuuhazkoinbaiuzdiyfjcvdpi","hxbscwfwtmwuyncnqewkfzuehfieizmswpkzorxheudejfszmomrpgvwmdawepobebassxbytgdeoxgansrcapboubnzsdazectzbvxxdabrzhrmblpc","cqswtfxmjznpbgofdmchodyolsaodrqfhlddqbrbaetekhjovlxmqvadncsqukxdvbimezpgfikssvinifzzabeqewiahgfejosnpitxqgpibzymexng","brwhqfhzlmdwcwjseerwkghofhalenrhgoowtvxgkbemxngdrzbehkuoruzyjrfrhuqcrnkdoosnbasuauahguwyqvwbodtvxjxrwhunvmaynvvprxwx","ssviqtmexfawqzpojkbgyehnzccqzbpttnelgqqfxsenrtbaffjgjqtkuycvbrpuevgnlyukqyxjsamxfvdqlzahzccawrwcmepzcmjukiecjqcqnhhy","ijfjojjkbgopmgrrsclclrhwhlowuvwdhdmvnyhqgvhsbyjtdxyoofmyqaukyrpfucchcjxiefaifmbijzyxgmvwnsjnjasfeupgfmojtprbdvlmwkjd","whblbkaklsrpogwvvmfodyrgvdsspexnnyzolzawurnkylgtynjdnbklecdtiagvahjljjjfdxrbkzwkohoeiypocujlwsiwbsimdrriqljbkhnbpbfz","buqgoztktbgvvohzibhymtzycnzrqetuajaoityeuhzqxirfjaexvfyyuzrnekhevhvecviwcjoarhhdklcftcfpczcillohujnwfxtjgjjzrrebejiz","lornpvvahkjbvwyattmbcvdtohwvqfwevnrkjpmsbwtwsrzomlppiskzchwuosyjisvtjhlkdeiwyhkkubbdwmeyvaujuvucnpxywiiapqypakbuldzh","rdfmfcxaxremickemsgbkeskouhcxijqorcttbvssceaeogsinwstofkkomjwxzkobgjcbbwdfyjvfcduyypofbztpipnicdlipqjqopynyvucbqcbht","gjsbacqpmutacisoagfavfwrixhmyrfgczhcezsqulsyvkoxrtyozugjtpxtgdzkegnihfbdstcpeqmxmklngtwzltstytedbrnjyomskohohvnvgaio","ueohziaacefdvsovjbnvrwlysyvaadoujedjnelriqwgkldtorqfnbgfzbfafwwqaazpgkiqcfwnsaigtzngavoaxvcerauucwjiiszlzxarzizuhobi","krkhooniojctfndqfcdecdxdlyytnbdxungidtqrcumkiqcnufuwitcvuaqhbtgvimflhyflsrxahzqcgmaohcmbecihwqegckslixzcowfwwvacjatq","fhujjcrhvvoxhglrfkutgzrewrjhuezzltkuydetbssiadcfnwawxscvllcfrbgcvtzvwdozxgizkmezigvhyackngrfhahetizpnnrmwzlgnrhvyfew","fgismcxvchcvrbmfrdrnefvrweoujstqadjofimjroejrtqiyjxdouwnbnjkhcdkioypwkzqafzsyrcxccctyagznpmxuphcdhrbusruysowlrvotzhr","cntrefoawvezfyczqutooinabkoukvnokifqnurlrvkwtpvmjrazbnzcypykmnyywdplzgxtdjrzynljgnjhdilbajnmwnluqagsidlnmemltzuzndiq","ottqcicbvpvnrbfzgsptxdgqdassgaiwudmylqbggxtxabzhtoasrilwidoqfyobbacorduzcqwdrvmmloffwsdgxsxcslgwoikflfgovctoafanthsp","zwvyqubkihgwrrdcyjsvnljnsldntveutatlwwwefeawvfavotqcgbrznwmgurcntvbrtzyydawbgxwwqpayquzfqmnkfqyanbtharhfsegyddwvsxtk","rtqhhdsotsqjtjsvbzavfjtimrdgoxsfsinzohnjzfsuokprmrmrahcozfwneptyzixnpmxqrrkicbzoumhxtjnsrkivbducltscipubgejkhjybvgaq","roliatgdwafjvxndohhxnqhuzixwqyphoaqovwrryycvwpbkyihlyrhazgypgnwupoikkbdkahgywhkwpujplsrkzqbffxavokhymnjourmtywppqzgd","rynsoqytqaqemaeynpohgaagzqvpretkcidqbdlrfevrezqrpeaxhbegtbxmfqwhbbzcglvlpqdvrvoibogirmomnmyvexchaelhrgsiyxdqsrauhgcz","stnihodnnhvnniweprmnopfjigdqohrjcetjsyxfhutvcrztimjzdoimwnenuvwxzrisphxwdsrgmrbwfkvkbfyzscmnxkmxburqcqnflgnxxptebppe","unensqcpdooekfxoykujqjgqazweqninbmctfekiuzogglvexrnqavidxehnspcveeqjkctgdjnkviquzgmbbugabpqtfsqlziwjkpsoyfavpqsqyeta","zacapsvwlnhkvdvhunvvuvsjokzmrtoqvrsklpjwcqixwggsvcpqzibpudclysbtlvfxkovmhglfmsxjwpbxxdnrirfilidxeiwozrdixqplkovgdwga","bvujozrzhuynfuegmhqlzfxktssxoyxsttbhuvjcrhrwcveqeubezyqtsisjhpbclemfzvjrcbpgywydqcjsczlvjdesufvhjhnlcwegztpyppbirmau","nnpwqvpmamulvjwzfaffwwfnmivduvzhiofajwplklzfuxebamiwinlwvhcrebapsgpdegrprqunnzpnlzlvnxukgwckzczrkrvrxogrecetbtjovumi","tguzewmdblxnesecgktmpxhqtqhonvygdsihrumuhjhmdmqlylxnkhgfxptkkttpobyfxkzguiuzukltvkggrolrdhbpcweqzcxwpyflhzkbkxwhifpb","tdsxmwoosthsxeqmfvxmvkphhmortetmjllvjajcvsusxmhcigqfqfmytcpmgkbryomhqyjlqfgpsptcvjhmrvmkxdxgoaxookvfkhsaoyqinjklvrxm","olwmovsevpskbqrlxjmnkewzngkiajwoutalospmkkylapxzajmknimcrwntgjhceknvcfhopfarwxsyggjvrvxitmbbwkeautvzyenplnihkcisjrpa","onkhznlxxpaukvtlaialylvknddywsamhmvjzgizxitieotgyvtwiqhwvmwrgzfolbzlhhmhqhpwvicvfvsoobmjnidthijvjkgtsuaibreybitgfnwt","oiddtgzcqkxavfvnzxxaodyrluxshuoyetbxbcarnztifoxeluhbzhsmbselosjunmsopugevzmaqjhdfqfexzqbtwmjrxeejytauzepassqdzuirboo","cgryddhuanymlrofstxtnplrofbfiqvnynlbssxvgwjtpxzkswfgnqxbyaigsftrugunzsihqrafobrjzwpmnoploztjfpazvuowowdepgmghdpjaevn","unaimvtrmttiqhgegklvsxdbaskayipsvpdhnwbzswjkfqqlabjuymvzhibhqranifwvdxxxvghbwymybxsamqbvyecovedgjzbpxamshuvfukevhyxv","qaqofteaxhgjhkygmmatgwbcghaphxlyybmfwrhwaofhafnotokcmlessehzeuzeymjufqqfgxpiecxyshaeugymngnrcnvabgvgynnflcprhmpzvrep","ycdlkrepgbpjhmphaemnhceqqwpopvdpahcmagbihrrqfiyhmmuvqbljzdxoyceyjgnlpotyfkrnupuhdpewssfrvehvglwsujdjxzjflasgrmpvdtrx","lyogcycilacfjgqghalsafysunpxjixugndklhuxhxeqfvymxkgzrhtlwklfsiaavfkjmfgtemljhjxgvdinkbahmnogvohtvtehymceynpixmossyfc","ailovawtqdomxsvxeyecltkigbbyzicbqqrosohitvwsnsstqwvbpimxjpxizcmqsdektnunirfvjzqbxlcntqmefmnfobxieduyqqnyhuvsultryygs","ovwuhlzxowhtbdtrtgrdcovwzpqznytbtsxcfybuwipxniohqhksvhrwwjwlhppdhofnnjjjtyhhgxoyfaschlzguxteokhyzonmxwxrueyceoalqunx","gofalzgclnakenyblwufaujgklraffaltfohgulskleqadrlzosbkbivmbvrgxfcfvllrwfbjkrjplwqbotlrdgffewnddpiycwqabtjnnueyqubgqmz","tveybdoegdphilxiossefoifffgnvvnosrptwdzdiqmqdlbsdvwjjgqolxegurxmkofjrgmbzyucjvuoqsxzzoqmnwvhpstzgaiziwahwukhrgwjbvja","lboaxjhmbcnjeyinulwthgczpaiqwtsjugktqtftwvdatnppymkgsnhhnpxllpvhyfboaijwdozweomcawktlrczjckuthbroehpntlqhknlbbqbzcwl","wzmfdybwgequlzjysxocjdpkgfmiikvgjhlohonnudkfetdxsuzezooiwcqgplmauzpbpcrlhbrnwwkrslvuclcaqsgffufbvwekavvhyoxxnhofvjzz","wbzmvhtcbzdwvkiwfffgucdhmrojcqiytjnrqgttfzrdjzbqeiwanbjzsykwqsvjbictowmwvdbeccuiktjzusynsklieguhqwahumfprgvviseulpuf","juuchgmloithftozitrzzmvjebfrqbxbytdfzsqqajxffnhngaoholstmxmebjgzdleeduuegtllguamuovjcpeqpqvqcdpfqvlwriazbnkiimwcdulf","jrvyisqkvfrocckummtqzgyhuwmxszceryczqvjocccfeobtawjzejjzhvwauzelzikrdvfgxjnezoxzkizpriqydmaznglmpxeutlcsxpwwfvysdxjw","hzvmnxlbewpvuvrphuhglgerbclhbudivawiyijcgzzcuqtdkblyhqpkucrwyxgtxfdxnnzvoyakrtqbwbzftqqoujmsiulgzpdoefkufmewhuaeyzlr","sbhmntfvosdpjjepoojtcqsjmspktbelclarhfpxzsmjbqyrgkniafumxjzqkdepqegxlxwmqjvtbwliiasifmwewvwgycvpgeotblgtwdpxbchjcath","mqnknjromodustowewpczeadghoijiryaeipqbdeqiykcogikylmclrlufvepncrtmhjqkngtosxczfpzqdbduoyzkerziisupekctsxhnummbbnseqv","afvbrzsqhbkesqqwklvtyrfmtiznopkqwgsnhkdrnqvigneqyamwrtkmcjzsbkjxsblznqsbgpjndpfdprcjlmvpyxhzjswbvhcjavmgkvvpmbtesvnd","jkshjcgsudvsmybovnvhkqxwrsampprycmiloogktbcibfwystgekfddzfrovjozvwmjnsviuasxfrwakcewjhciptwmcmlxlxiasgimgdlluhnelsdu","bfeqyacdppcaplahtkvzngmhqaoburyxycqydubukgwzrwikidlwlzfbzvdvmbtmdlnifoerwasnwazhfmdrmksngxjuyejepwmwmrojtgyqjyzomefy","oamuxxrwdaauwoqiherbnqtwqsmcwsbmspjpmanrcplygbipicqxslvkfhodzrqtgbludylfqwdwanlkpehjrctxjiclzugivrcysqdioieqypanvhxn","jsmvcoielomggqhyimgxxmnvbokzxjmjcyegookzcwikppixdquackxgyifxttgvrmcfaofdlnnaeyxhqukvejbetibnbkkuwozxdgcqvrszprjilvdr","ggxaqbptlznhoogtvijqabsrudzgaezgkzicaxvnxiwnxdgulpknsehmjgujnwszvacvyxkvggifjqzxflmzstlbcgnpcfozfqwfqgcymkdyaevhpjgh","dujfcwugdifibbqrjspxduvfyspncxxftimvegbjqirtljmucduhxpovidlmdktwsfsynvhdgazrklompitozhmjlxvqhombvgziegokgndqarcpbveb","dqkqpigyyuzudychgstmfwdiqfxtddwgvjymrgkpallflqorihgqgjyyqxrtdqbyzzlqfxhiltnylcstlylrhjrzhltkbwkawxsdvzniubgffybswmmf","wdhfoarrwdrubjaylngfqonxpoqlcctahafycypachxdsxddkjldzaaoqscsuxtexacbzrbdyaitxlwkwjnvjpmziouelniknkloeorepzxmkuygflep","dqqlekrrzabpmodscxxrwugjqerwsvnvnditqbkrdngqbmiejhxfcdoskgocddzrhjkzkxqokzgmlqsuypzcvqufyljdqkwzvjyhgrxsqdebwyxwoyyl","ouqohbsylqxgzynfrnyhqekodjmthmeyjwmqxgqixqqwqfehseqlicbnloiuaoslkhehnurmmjleppnjtdwdhytuobpqqhccogkecdspndvesjpnmmtw","moqaphqhrsmhayldbesqjnueymrlymjmabmsjebaznhzlvcnbwdkmaokmixmugyximptqqtpecrpxteaqknekboylmmiukfeyuxomqgqvziusmvkyiok","lfiztwhniosgirxwifndexxylujkezuqgfpzbynkmhswypsiuhnaenzqhkamlwesbvrdvgphnhdoxxytfmujzvbifdwqacibxaeugvbwdgmcekvlyrwx","myitbgkbjsfiulddhgbmpnovzlgyfcxrcflgoxjzpohmamphvsvkfjfewlcbpctuhgcxdlwucgicuzlprgzyrednrhpjjkftqhsvuprwvcypblhtrgri","nwwgglrrxwmnffkaudwrfvihipcaytklsityvlrsjefpjrpfxnwckgltwnvujfhbocbjnsezylohdfoaumeftqyrdtnmaupqyqcmlgnjrdtukhweubjn","tjewctlfnavntxbgdopvrirbqqimrrbmbfkfavknyiatfczjsogkzxnrnvdgpessldxlakaasctxgsizjolkoabdygknmehzjekmqmmkqgixasyjjlvx","nyanemcqtjpeqbqgpdrglbflvfxeqsdfrgtxuvqpfhuvlkdapugcxlovsnzihfqyljyheoxlvrgidkjvgrxgflbxycgihwguhgcnuzzsqfavrlqadoii","zlfannkxlsrsztgvufpmmqigdyigmsoodwqsjapxshrtcxpxeeltwtbasligdzwgvoygqodjxvebutabamwwfxyzihilggtdvtjljpwgkbkgwkhwwdte","crfkanxguslrmvcvkbewcocyymvxpqdujiekwesswejibngnokjsanrazozrgclplrbjvwbucmcdzkqowbgwozxopwfvzsnmjqvfmwzqkdtjolzkmgjd","hirxgyufqhtbyoimmhdwnygdmfpanydviwupuowmyqoyewmtgppvqxycfpcuqgryclnzcknccbagambietduqdyxucskijlnxaobkbdmffvhryrxrwti","bthvwziglttitjjgnoustrbmqskhofrpzzmvaublpxvliervunpnfqaxkmgararszenbarnqqibypuwjhlxoezlqlureuixvokwpdlftuiulcqwlbvah","unyhhrmdzjyqvvfzimucuopyemjijlrezpligzmiikyehffsrzunomnuawejkwnjlbtuafcjscpbhutytqnjcagcykliibtwenqeuupmwgqfajfwbshf","unhsavdiywgclwigsauqgkvjwahxsqdmgmhgjkqjixluvwaoyweehcpfcyevphjvwqdhatrjsefqaheydkfmmwrpvwmkfxfboijqdcbwggmhpshtemft","jzkevyqcvxglfrektfizowidqqyveeopdavaylctiihpzlassiugfcmvsksxqiovikxivaegklvmwvgogaxndlkxxdwonllwvjeqjiwvvuhrroixohkt","svrraphnatlvcsoncmkygsryizxyiiscfluhabwbwiyyaoncbyajsujavhyersiydcfggbjcjhdlwqqzqsiimskizjosdwqjzvphyyjkhovfhlexepiq","jsaidoahlsqmnhtlfevovtuceabkpjdycfifukohcetrlofsucjrvftcfvmxerxixiqtueazlvqylvthaczvjsxqpmpwfngcxwxrdxsqulofijninmew","gdnwpcuvrazozxicwcsrniwwslefxicgmredtyalycbzblbxovqbenxwacdymfgawkesigdiigijslhihzjnmjlpnonzwvcufgmporzxyhgsvpaeplrd","uesjshlqcnljvxyjrygrhplegnixybdvfveafrqjebtzbtlurtlbiwfrjoojrrexplxucpfjryiustolpzoxxuoikfrdwyanlzhppnyinjchesvttjrq","fhyrorvnpxaaziqoxqymzcweurxncqfkadbouybmwcovmellxjzwlvchmaurszbuecjadmmbqdyejjrgurdhmfobhkscjvwpzhrcugdmjbrsmizgbenq","ldrvnlxwgvnhdfkzlpluteofpnoqrdgdhzaumxtuugcxnoyadkwyqlefyuysxgxegxbuwupqcrqqfoqkapjrapyajwuidrplqqfmkwfmpvewlxhmmsdm","hbosyjadcpqtfxhruoejjkgvhphthmhqnyinhisjaiehgmzcaflmptjxissrechtapjjabscmzjslkwnphbhdkgneyfkcoeeenngqikchtwseshvcjcf","viuajzkloqqufdcwlmauhxonrwjvhncewxefyrsojikpomnbanwkmkxgiibrwewubabbttqdeauunhvpwtzjgzpqhsifwezzgabcwrfatzuiiryenznt","yejiztnvzpxgraintppmqlvyfvesusnvywdxssvrhuzbujqpygbqtyqytvqqpflpconwiknqgnrawjpxpsplrgjmdccshnhldwhmixeomxqkghjyazjt","hsfkwkcgxlrdibpqavhmsxyyfiwfjhaqafayreeppyuxzlqbgxpyunybxxigeiwgqyfhclyujsrkdjllialdomgljpupxswnrdxvqvpaqjkvswhbwugm","goapduhbmfqfipdansadblawjjzhehukvwczqjceoumykpyxhbclocjxmigqpcckyglqpnvfkjfuygthhvuxxdullabcdgpdmcuesrlcarwyzphimcfj","hbvvdyxieomtrgxjxknzdjzcagkokrxssunwtmezdquuytfvesuhdtmfcytmqsgkptgkillldghczozfiwpnrbutbpirhocwkkiuxufbaofbcehkcyzu","ztpcizurqyqaiywgsdjsrowvuffzdgtezkgjkcaacqclrytjbeesuapohunkciqbtymfbmfdfjqwhlhkrlelntaupperawuvvgayuhdzquxzhflzqpkg","kmazehsedmbaubyqkcscypbhwogpdtvnhvolcgriusiqvhgflyhjokqkyzbduwsbsgpwogeibpawyhejfnsvakialjefgyhahwwvedgfsgespkbvzvqz","faatkgysgfsndqlkvtrpbxhrhiohdeilhkersejzmdoptbzrutgwqopyydhejrpqevhwzsxlvodrpeimxqiqexqdczhlqycuvjtwesizgnsytaktrujx","tzcvylgolilgugdyynxhcqfvsrollxjewnzwzhnkqytmgykeljlpbskwjbhuasazgbvhjitbimnomztzigokzzgkcpfcihbqjxzsfsvqhketjztrgjdh","ilrmbyplgqbppajvuendqrxzrsszbwimhzykypvggyvvagsvmfyczxbsrtrvrbhbahlaxhgfhdaijvfvcfxdfavwuornpaoskashjboqeoaolflqnjts","jpqfdktvmhnwjffsitlnkldvtolgzfalwqsbcnwpvjlgrrzzkkowxtsqifyjmauitpkvcgmzsyglrfmdrbaqwujgzhqoimwdbiyerldlllwcsihjljci","dlofugtctrfwagattgeeraikkpvwbxgekwlfdgjwyrsaxvtqdxwuzegjvehwbndokotnvclvtfvsaokfngamkivimdeqsjecaxrvbesxmnpodauqguct","cxbrchhvrlzrkrolxgkjvayycsokosfspijuqqpjdocnhsbfalqvnovrglcudhpsqymipdtssxizpjgrwxmknjbuufqxpfrhegrvjkpbhxdyilpfkdry","muugakdpsuyyapvkzkniisiqgxxqaoomjiulvxcptanwrkisuvaeqixyhuqhlfvwpphmoldjnsfecnwxlyddgabnxrwiyteqineyyihnanrdcncnlhqt","iriflgpjzvbjighioqvqfovibzvohohphrwsxnewiffsnocbezumnpuqrreyhnppenjbanxivecisemyfgksxgioaomjbdyfqkgqxfaujcdbgrzlzmfw","upludzeedejtormowmkfppgxgilfwqeqgrnlstqvzbrotferroxggfgmprunjyepptbhotfnwydrdjjwaidgpluhcouloadftgpjzwxxuapzkyvmgasx","lmepdzdrzgxvoogpkdmggbfszcehfwfqklinklfmtejhspwevikbmrtlvzvavctfnbtaoaohgxoyomejwomihhwcgtddvylkzgkngywmxmmoyqzwgohp","vfreawhvushvyukguguusiisajrgxyxtfpxflgcizjdzfogawcurlejlnculcrghifowlqemcjmhzujwwdnhjyvxdpkfisprxdniwtvycjhedrabwplg","pgdsxpyfhnyesnooglmlwwpznrdlgorvuwqrloyudzyvopkxcyizuzajqdvyrovnllgybhtegtauimrnkbmfcoqusnslcqznbfldmehuyjrivkvgmjno","yfjstddvtcixkvawajtatkiqugyipnzptkhmnljjptgzogyqrrqmdbdxjbiyphqkrxyeihnaavbodzhvszhvcmvlodmfmcrdzpjkwzmyunoynvthvcfx","pclffzmrbdwcsfoqeaozoczdyukvwpulrfsyeerhhpmbvarbdfcrkbuivgfuyzhrhasnglxqbjrwjlzmscfcfbmbkrxirebaetnnfkdgvuefhdtahbcn","cpominwbrybytrlybogzkmesqzszcwmfnctwpszhqbfjsqkvgsuqfaixccwebjlolfmdxmkpprahjmepfbfkbqhfsfktovkccwfbkrszitirfnikonwr","dfxwljrbgbfjymmkdfknasghfouveqphwofhzzkfaqqacdlikvvmpetxsnuygjiczplyovernwrqbeylbvxrztouiisouaqtsdsgbyxourewvejxajqz","cetkooziqrcixwpyuooohvmdzwczfsbjywvmkwxbozlnxclrtzhawwfwshxzbykzvfohclismwhjyscrtjsqfxozhlakkkkhsaownzozvxkvpmnkxhcf","gsenehyorkxlmlhzkxafukblwqytxayftftzmtpffmtrxaqiyqpucsgyiethgunbzicndruidnzdorlojcilxqlfwepfyegzmlmpchzguyjkrwaaalnx","byfacwfdancoypfbyejueuhvqhxsskqwivwmrbptouhpjoqjsbdyvktnuqfmcvikseylhqgyknnvdfexgjvdwqqqivcktnwltxzbnfzxvmsytyybjtef","muvupahkpdyiaxjpekmzwgargysqtwxfqvcixjsmosurpgguqvvpdxgmvbcrxzwqwaatjufancrekzaawwratamrbqiyrgqojqhslpuatlednffjdxjy","xxpynzyhipvrheluvguqtztigzsjydjvbbvqavzkkudubpoyxjpskibqjvbjykgblbuoxtajqedtvurudgmnrpfckimlssmgwguvcugsamnvgepjneyg","tfignwrhrdnpmjmqgsigevekbttoztwtafbndsvwxkljuxbcsjiwgmhkicahyxcyedmhvjgvvterrgtlrehaqokatmirjmpnqdxnodikwpdpxxaqbiqt","ycutpekaqcoihlwyqgimvneukelnodhpidizjvzbznkiaigqoodmejgonreexnvfqfebadcbtmktuqklhpxlyfbnxftwsobkwhlwkqafcmzzclmlcjwc","oyrnfnjybmkxtywgoylqkmrozdadowffwzuemgcpsopmmnualftvumlvqlzgkglgfgkrmojgfyurlouwwntszenrsmyctliytvshlboqzkkmzekvtfpu","jcmbpmdkzokvlecyfspgdbuehebajqwvskyjyctysgtfkxdssuyvvtbezcgjsdemncwmgrmaxhfkgjcyfcvbvwfxamgsrmhgofsxwgxwpfgwokutmswk","oehpsnjjbqppvkousmsiraehkacwsbijhpazelkfebxbnlvgznqspwzzyeytfgcmyenerzkvajxquuywkoozkqziuzdbhhpflckfbwadfxtburzehodt","eeeadhblpqscuehxcicjhynbpmfzalsepwetghgvxaxtfhshpvryteckqjjtuezkcefinlfnlfgsmzcbwvbpbdbtnnmhtmtvsygfllszqbrcctfyqhpr","mslzfxjalcwddelopfnighmkcsitbzkpuxpbxacicyofczwtgjdnqqxtkimnjycdwtfttjdyhrflsbgzlkodcnwovkbhldmhzrcsafqjxywrzfqmreqt","sohpzkwmpltocvjfcbqbzptzullnqdgkspbtbafqlahpxqwzrnbtcwuyhflzltjdknylnddydkpccmbuzepdajdkqojbjvgtiegxjjvowmqyysuxyjcz","sfjjvumgptzxxhwhtrvpempegkcevgfomqzjllqcgrcebynuskjywacekglgnqwbjxkwkcyrwcxxbkrvucttcxxpeixtbvumsgielixhnueqgvlbzgwb","dtsjepchkwtefdlqnizaddqjadmzjicnevykmbrxzmderowezvheaxnadcbmkebqbaanbtmcfshwifdhdkldjbgmdhzplcioeichcqkjitgryjabvohe","pnruusliutwbcaigtspblxumixpdlwicjbygtjopfmqjpzpitglhegtofisqfcuqdswydmpizitqjkycrjjxrclwnfosjikochoiveswmmmvwkxpwjmn","namahaurlfhnowxjaqgmcsjyfiobrcofeahmdcfojmdxibikroyvjhvoqlrjofqsiygnalbjagikjqvcftxqbtetexcuctpmtxztjcellmvueqzjmwbp","rhiyemujhjvahxtsbzfmnajstidfgfuameyrqucyexynwuhyvmmjoxbhhgoqlkqaqqthkvhquhfrdmrzadkrdnaktpafbsfsiabtvklprrgxfzyidizi","vzsoqvvsncmwcprxzepsvxpdxplcxkkujclczgwnlklpzenaiesebkjyzuazektppetonpdyzonyscabgthkfqigmlfqxzhmfbdssgssvgspktstobdt","tnbfahxygfmlipgayyuvgpkrkdmyertygufhbdhjivxslfuldrgmgqfqvrqcklcqfhzjkguuctopyjceciqiavawmsawdcoklovwwssylhpksroubeec","zganyaldcznpnllkdgkopcajvqfxujzvrzkpbvsfxhuksiwvojmdlmogdtfzcexvfhkifencnioiqndgwrlhezpjsviwbfrjpdrwjfywnoefbklxdwgh","vwsnrbjuicdzfvvoavmpktulfflibrswpklinudywgzdbvtdqfscamofrbqsuiqkubskxxivehahetlvzdzzqphjqxclhuxbyrlvpvtvftcjnpgotgpl","vwuovybctyerrroinhdsbidqxkesstdnsybnyesrcwkwpzeciiwlsabrmhkednrvnvkmzcfeasaqtgubotpitsahakldzeapbmddpkjrcjhvrezixoqs","iqzickneqptscyxriginpskgwjovzhnizmscyigoxbizzfsjlbwcvjltsbouibeipymngsdevodwvwhhzglwpwpjafdigjsxiemqyruvfarbyzkzhvvw","umfurlezuzwefivgzpbhrvipwuodrlzlxghqropmpnquvlaxdeeubomzkacbmdpljwcbmtpbhhwevybyehufxgehjijxnyixwmajgpmpykttjxtpeove","wblfmwezwnwvbyejpsyodshmpbbvryzncnvolznkomfqmlzcdasguzujcygtwijaxeqidgssszkgkliolauhcpqgnzalhloepeoukjoeialtmvjzwdha","uzgjaixhtlnkpehcnvgxwtskpblnfunbuvlueiezvtmmxtomoxmmqeyfgksnehqadbxjlbigwutupjiegusxbtchdxwjemmhqjqbmbkixfenoptvlnsm","gwvltrvyejhwsaxgdjqaovpdmkaxyskeqhqkznkfwtbqvawykmbyjsdvddvbxhhqoxcpmmuihxydyubijeisxoqatldrskjiilywxufgsfjqanalrkfq","yvquitncewlohjkgfrmxxwpzlpkecpvcnnwvhjynfjdmupubjhzgfohqgtwikrkxfjvostdaeioazjbiscqxrxpzslhdftcmexczsfzwppyoacxsenrv","niuhudkbzpndopchwdfltezvgyokohibqeikivnhmamarphnsnantzjbyxnmexpuczgmwvvivhjowsdrhdeadnddkrrroinsjwegrzqphbffujwbmber","ohubylupvjhfhmlbndswfxczgyavbemsohtoupdqanxibkjonblsaprhpucraqjoxefuvimvxjdytmpgpcbqruzgodzrtihtomnjxzfukivdxklommed","hdlxilocvyvkkkthjyevjzaijlwxabajgngpyxtuxoghyzrjavglugtdrratuccdrlusknmhduodthovcuiwadbtvdnphpszcmtmbfvebmhwtxswrcur","gynbbaslrlmwzfibmgfnspjlmdjggezmcmpfohsgsgcslmvzscokryygdhojnnxrcmzqurwoaainpdnhgbuzbuhfbvqrloipcjfwdendgvqvzddhhzgi","tqpuninyyynahvzkzmnfhebijgpqfybyosubaicyirbpmaanmntvtwedevtjtwjjpflppnqxernttngfcbcwxizbeumztvjibwzqlporidkbqrissnqs","vpvbmidffmpikobvgrmquzsmqagkpxeloaoakrhrfwapldmtuzjqybcqeictfhgujvwtmemuamjnryglzqbxtfpzotvvabrlyogluthwhskzqskpkooe","tfdhzafbcwnamtngmufupptfhfxutlynrdwsebtiagioawxmscihrbpajmuczurqaqketemtkwimuhbnjjwcnnewzzazvsrvkcbdipzsmjhiqivzrubg","hhejgfiezbbjfdonupigyppqxmpqiszsadbiilohmqssvjhpypyxepnbdfumztebwhmhsaogsjansifqxdpcsffvmzjlupprwbyqdoxyzzlthqkhvbjp","gqlsswgmmvfkyfbbwazvznpjfbqdcbsltfdlclaogfaelbijbjedyvogwejbhbmajroldobltbsgfarglwlktzqsfbtochplafyftbrodjxiloqymcig","dayjdtxgcotctuiovbdakakxodvbhgjkghvmatsejngfjqthrwhdyuapxwsecbokkmwmfqqqgwvrnrygngkoakdzivdmytzifxumqkdwianxroehuovw","aavlxaxvtwfzwznmlqittxrklxthlqfnqcypcymyurxsskefdozwmsizpehcuoplrqctoprkgqdbdhgiwhgkzojqsssphkayactqtnacdddinjqlrwvs","ngjhzdwinyipdbfwqiywldeanxlgtiaiplsopoyengusjboajpwxsczhzlpvtqdibxysmwxbettowjqiyofrqeasrqnngsvjqweeubfzwapujhckvhdn","odfftusbnqnforjiuqjssambhpleyqsmuzupuotjgiquzbfvronjrzmyoafpqxbmwxcsovbwdtreuyznooyfnlgenltdiwqgwuzmrciwwzaszbgopete","pzkckfiueabaucolgwheyjxxmdldhhhziudtzlpdnsfhutsdsbhqkepwjbztkjssdxneldkyvrgsnavfccxojmnuponzzhsefhjskvqgmyyzzvgdzdri","qgffvshucbzhikbtfrbrqztrwzuvfngvwlcrfjnhmoqvarqflrzbsuuovojadpvzcasilipyyitzzlgkehnwbhmxxxzdpverxzzihrghzbiampnqyaoa","kczhaampvrgssidbzjiylrazinsgoiialhjliwcfpiahqdirosrbjsdrfvyvfgvqqfdadfhsqjbiojaddtgnljgtegqkpmcftghylqqdarmocmtffaut","jboqjecysefnmmlafbdfupvydrgltaecdsunyylrfrerfqrktvrompoqgudzxjdadapbybsduzvbromklfaywpqcjvdgejjhlyijbdpxekzvanfmsgmp"};
//		String test="oajgdkcokvfpdaslnmomrpgwitwdoku";
		String[] str=new String[]{"ABCE","SFCS","ADEE","ssss"};
//		String test="ABCB";
		int len=str.length;
		char[][] ch=new char[len][];
		for(int i=0;i<str.length;i++){
			ch[i]=str[i].toCharArray();
		}
		System.out.println(exist(s,"ABC"));
	}

}
