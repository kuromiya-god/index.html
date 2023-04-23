<div class="tab">
  <button class="tablinks" onclick="openTab(event, 'tab1')">タブ1</button>
  <button class="tablinks" onclick="openTab(event, 'tab2')">タブ2</button>
  <button class="tablinks" onclick="openTab(event, 'tab3')">タブ3</button>
</div>

<div id="tab1" class="tabcontent">
  <h3>タブ1のコンテンツ</h3>
  <p>ここにタブ1の詳細なコンテンツを入力してください。</p>
</div>

<div id="tab2" class="tabcontent">
  <h3>タブ2のコンテンツ</h3>
  <p>ここにタブ2の詳細なコンテンツを入力してください。</p>
</div>

<div id="tab3" class="tabcontent">
  <h3>タブ3のコンテンツ</h3>
  <p>ここにタブ3の詳細なコンテンツを入力してください。</p>
</div>
/* タブのボタンを横に並べる */
.tab {
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  width: 100%; /* タブを覆うように幅を設定 */
}

/* タブのボタンのスタイル */
.tab button {
  background-color: #f1f1f1;
  border: none;
  outline: none;
  cursor: pointer;
  padding: 14px 16px;
  transition: 0.3s;
  font-size: 17px;
  width: 33.33%;
}

/* アクティブなタブのボタンのスタイル */
.tab button.active {
  background-color: #ccc;
}

/* タブのコンテンツのスタイル */
.tabcontent {
  display: none;
  padding: 6px 12px;
  border: 1px solid #ccc;
  border-top: none;
  width: 100%; /* タブを覆うように幅を設定 */
}